'use strict';

/**
 * @ngdoc function
 * @name prasdesClientApp.controller:manualCtrl
 * @description
 * # consultaCtrl
 * Controller of the prasdesClientApp
 */
prasdesApp.controller('manualCtrl', function ($scope,$http) {    	
		
	$scope.nosel='Debe seleccionar una de las conexiones activas para realizar la migración';
	$scope.noseldate='Debes seleccionar una fecha inicio y sin para la migración';
	$scope.operror='Ocurrio un error al realizar la operación, en la consola del navegador y el log de la aplicación puede ver el detalle del error';
	$scope.opsuccess='Operación exitosa';
	
	$scope.warning_msg='';
	$scope.verificarSel= function (){
		if(!((typeof $scope.selData.idCustomer)=="undefined")){						
			$scope.selData.sfechaInicio = angular.element('#sfechaInicio').val();
			$scope.selData.sfechaFin = angular.element('#sfechaFin').val();
			if($scope.selData.sfechaInicio =="" || $scope.selData.sfechaFin==""){
				BootstrapDialog.show({					
	                title: 'Warning',
	                message: $scope.noseldate,
	                size: BootstrapDialog.SIZE_SMALL,
	                type: BootstrapDialog.TYPE_WARNING 
	            }); 
				$scope.warning_msg=$scope.noseldate;
				$scope.showNoSel = true;
				return false;
			}
			else{
				$scope.showNoSel = false;
				$scope.inprogress = true; 
//				$scope.selData._csrf = angular.element('#token').val();				
				$scope.ejecutarMigracion();
				return true;
			}
		}
		
		BootstrapDialog.show({
            title: 'Warning',
            message: $scope.nosel,
            size: BootstrapDialog.SIZE_SMALL,
            type: BootstrapDialog.TYPE_WARNING
        });  
		$scope.warning_msg=$scope.nosel;
		$scope.showNoSel = true;
		return false;
	}
	
	$scope.showNoSel = false;
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
  	
    $scope.verificarDatosOk = function(dataObj){
    	if(typeof dataObj.idCustomer==="undefined" || typeof dataObj.sfechaInicio =="" || dataObj.sfechaFin==""){
    		    		    		   
    		$scope.showNoSel = true;
    		$scope.inprogress = false; 
    		return false;
    	}
    	return true;
    };
    
    
  	
    $scope.ejecutarMigracion = function(){	
    	
    	var dataObj = {
    			nameCountry : $scope.selData.nameCountry,
    			idPeriod   : $scope.selData.idPeriod,
    			namePeriod : $scope.selData.namePeriod,
    			serviceUrl : $scope.selData.serviceUrl,
    			idCustomer : $scope.selData.idCustomer,
    			sfechaInicio : $scope.selData.sfechaInicio,
    			sfechaFin : $scope.selData.sfechaFin,
    			idEstacion : $scope.selData.idEstacion,
    			idVariable : $scope.selData.idVariable
		};
    	    	    	    
		var res = $http.post('/manual', dataObj);
		res.success(function(data) {	
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