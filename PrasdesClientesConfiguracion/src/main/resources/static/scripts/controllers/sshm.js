'use strict';

/**
 * @ngdoc function
 * @name prasdesClientApp.controller:manualCtrl
 * @description
 * # consultaCtrl
 * Controller of the prasdesClientApp
 */
prasdesApp.controller('sshmCtrl', function ($scope,$http) {    	
	
	$scope.operror='Ocurrio un error al realizar la operación, en la consola del navegador y el log de la aplicación puede ver el detalle del error';
	$scope.noseldate='Debes seleccionar una fecha inicio y sin para la migración';
	$scope.opsuccess='Operación exitosa';
	$scope.warning_msg='';
	
	$scope.verificarSel= function (){		
			$scope.inprogress = true; 
			$scope.showmsg = false;
			$scope.selData.sfechaInicio = angular.element('#sfechaInicio').val();
			$scope.selData.sfechaFin = angular.element('#sfechaFin').val();
			$scope.selData.idPeriod = angular.element('#selPeriodo').val();			
//			$scope.selData._csrf = angular.element('#token').val();
			
			if($scope.selData.sfechaInicio =="" || $scope.selData.sfechaFin==""){
				BootstrapDialog.show({					
	                title: 'Warning',
	                message: $scope.noseldate,
	                size: BootstrapDialog.SIZE_SMALL,
	                type: BootstrapDialog.TYPE_WARNING 
	            }); 
				$scope.warning_msg=$scope.noseldate;
				$scope.showmsg = true;
				$scope.inprogress = false;
				return false;
			}
			else{
				$scope.showmsg = false;
				$scope.inprogress = true; 
//				$scope.selData._csrf = angular.element('#token').val();				
				$scope.ejecutarMigracion();
				return true;
			}
						
//			alert($scope.selData.idPeriod);
			return true;		
	}
	
	$scope.showmsg = false;
	$scope.selData={};
	$scope.selData.sfechaInicio="";
	$scope.selData.sfechaFin="";
	$scope.selData.idEstacion="";
	$scope.selData.idVariable="";
	$scope.inprogress = false; 
	
//	$scope.selData._csrf="";

    $scope.setSelected = function(country, period, namePeriod, url, customerid, nameCustomer) {                             
    	$scope.selData.nameCountry=country;
    	$scope.selData.idPeriod=period;
    	$scope.selData.namePeriod=namePeriod;
    	$scope.selData.serviceUrl=url;
    	$scope.selData.idCustomer=customerid;
    	$scope.selData.nameCustomer=nameCustomer;  
    };
  	  	
  	
    $scope.ejecutarMigracion = function(){	
    	var dataObj = {    			
    			idPeriod   : $scope.selData.idPeriod,
    			sfechaInicio : $scope.selData.sfechaInicio,
    			sfechaFin : $scope.selData.sfechaFin,
    			idEstacion : $scope.selData.idEstacion,
    			idStrVariable : $scope.selData.idStrVariable
		};
    	
		var res = $http.post('/sshm/ideamPrasdes', dataObj);
		res.success(function(data) {			
			$scope.inprogress = false;
			BootstrapDialog.show({					
                title: 'Success',
                message: $scope.opsuccess,
                size: BootstrapDialog.SIZE_SMALL,
                type: BootstrapDialog.TYPE_SUCCESS
            }); 
			$scope.inprogress = false;
		});
		res.error(function(data) {
			BootstrapDialog.show({					
                title: 'Error',
                message: $scope.operror,
                size: BootstrapDialog.SIZE_SMALL,
                type: BootstrapDialog.TYPE_DANGER
            }); 
			console.log(JSON.stringify({data: data}));			
			$scope.inprogress = false;
		});						
	};
  	

  });