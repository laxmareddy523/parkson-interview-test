angular
		.module('ParksonApp', [ 'ui.router' ])

		.run(
				function(AuthService, $rootScope, $state) {
					$rootScope
							.$on(
									'$stateChangeStart',
									function(event, toState, toParams,
											fromState, fromParams) {
										if (!AuthService.user) {
											if (toState.name != 'login'
													&& toState.name != 'register') {
												event.preventDefault();
												$state.go('login');
											}
										} else {
											if (toState.data
													&& toState.data.role) {
												var hasAccess = false;
												for (var i = 0; i < AuthService.user.roles.length; i++) {
													var role = AuthService.user.roles[i];
													if (toState.data.role == role) {
														hasAccess = true;
														break;
													}
												}
												if (!hasAccess) {
													event.preventDefault();
													$state.go('access-denied');
												}

											}
										}
									});
				});