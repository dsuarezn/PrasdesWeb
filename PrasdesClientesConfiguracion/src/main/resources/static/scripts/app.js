'use strict';

/**
 * @ngdoc overview
 * @name prasdesClientApp
 * @description
 * # prasdesClientApp
 *
 * Main module of the application.
 */
var prasdesApp = angular.module('prasdesClientApp', [
//    'ngAnimate',
//    'ngCookies',
//    'ngMessages',
//    'ngResource',
//    'ngSanitize',
//    'ngTouch', 
//    'ngRoute',
//    'ui.bootstrap' 
  ]);

  prasdesApp.config(function ($httpProvider) {
    /*
      Código de configuración para hacer el llamado por crossdomains
    */
    $httpProvider.defaults.useXDomain = true;
    delete $httpProvider.defaults.headers.common['X-Requested-With'];    

  });


                

