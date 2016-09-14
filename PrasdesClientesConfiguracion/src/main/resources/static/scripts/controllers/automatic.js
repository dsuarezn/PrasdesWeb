'use strict';

/**
 * @ngdoc function
 * @name prasdesClientApp.controller:manualCtrl
 * @description
 * # consultaCtrl
 * Controller of the prasdesClientApp
 */
prasdesApp.controller('automaticCtrl', function ($scope,$http,$location) {    	
	
	$scope.migTaskPath="";
	$scope.selData={};
	$scope.selData.idCountry="";
	$scope.selData.expresion="";
	$scope.selData.idPeriod="";
	$scope.selData.idCustomer="";		
	$scope.selData.idEstacion="";
	$scope.selData.serviceUrl="";
	$scope.selData.idVariable="";
	$scope.selData.noDays="";
	$scope.selData.selOpMonth="";
	$scope.selData.selOpYear="";
	$scope.selData.selOpDays="";
	
	$scope.pathMigTask="";
	
	$scope.showNoSel = false;
	
	$scope.nopath="Error al obtener la ruta de consulta de tareas";
	$scope.errorTaskList="Error al obtener la lista de tareas";
	
	$scope.nosel='Debe seleccionar una de las conexiones activas para realizar la migración';
	$scope.noseltime='Debes seleccionar el periodo (cantidad de días) y una expresión válida';
	$scope.nocandel='No se pudo eliminar el registro';
	
	$scope.setSelected = function(country,countryid, period, namePeriod, url, customerid, nameCustomer) {                             
		$scope.selData.nameCountry=country;
		$scope.selData.idCountry=countryid;
    	$scope.selData.idPeriod=period;
    	$scope.selData.namePeriod=namePeriod;
    	$scope.selData.serviceUrl=url;
    	$scope.selData.idCustomer=customerid;
    	$scope.selData.nameCustomer=nameCustomer;  
    };
    
    $scope.agregarTarea= function (){
    	
    	if($scope.verificarDatosOk()){
    		var dataObj = {
        			expresion : $scope.selData.expresion,
        			idCountry : $scope.selData.idCountry,
        			idPeriod : $scope.selData.idPeriod,
        			idCustomer : $scope.selData.idCustomer,		
        			idEstacion : $scope.selData.idEstacion,
        			serviceUrl : $scope.selData.serviceUrl,
        			idVariable : $scope.selData.idVariable,
        			noDays : $scope.selData.noDays
    		};
        	var res = $http.post('/PrasdesClientesConfiguracion/programador', dataObj);
    		res.success(function(data, status, headers, config) {
    			$scope.message = data;
    			$scope.loadTareas();
    		});
    		res.error(function(data, status, headers, config) {
    			alert( "failure message: " + JSON.stringify({data: data}));
    		});
        	
    		$scope.selData.expresion="";
    		$scope.selData.idCountry="";
    		$scope.selData.idPeriod="";
    		$scope.selData.idCustomer="";		
    		$scope.selData.idEstacion="";
    		$scope.selData.serviceUrl="";
    		$scope.selData.idVariable="";
    		$scope.selData.noDays="";
    		$scope.selData.selOpMonth="";
    		$scope.selData.selOpYear="";
    		$scope.selData.selOpDays="";	
    		
    		
    		$scope.$apply();
    	}    	    
	};
	
	$scope.warning_msg='';
	$scope.verificarDatosOk= function (){
		
		angular.element('#cron').removeAttr('readonly');
    	$scope.selData.expresion = angular.element('#cron').val();    	
    	angular.element('#cron').attr("readonly", "true");    	
    	
    	var checkdays = angular.element('#opdaysnumber');
    	var checkyear = angular.element('#opyear');
    	var checkmonth = angular.element('#opmonth');
    	
    	if(checkmonth.is(':checked')){
    		$scope.selData.noDays = $scope.selData.selOpMonth
    	}
    	else if(checkyear.is(':checked')){
    		$scope.selData.noDays = $scope.selData.selOpYear
    	}
    	
		if((!((typeof $scope.selData.idCustomer)=="undefined")) && ($scope.selData.idCustomer != "")){								
			if($scope.selData.noDays =="" || $scope.selData.expresion==""){
				BootstrapDialog.show({					
	                title: 'Warning',
	                message: $scope.noseltime,
	                size: BootstrapDialog.SIZE_SMALL,
	                type: BootstrapDialog.TYPE_WARNING 
	            }); 
				$scope.warning_msg=$scope.noseltime;
				$scope.showNoSel = true;
				return false;
			}
			else{				
//				$scope.selData._csrf = angular.element('#token').val();	
				$scope.showNoSel = false;
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
	
	$scope.loadRuta = function() {
		
		if($scope.pathMigTask==""){
			var url="programador/rutaTareas";//$location.absUrl()+ruta;
	        console.log(url);
	        
	        var httpRequest = $http.get(url)
	        .success(function(data, status) {		        	
	        	$scope.pathMigTask = data[0].rutaTareas;  
	        	$scope.loadTareas();
	        })
	        .error(function(response) 
	        {
	        	BootstrapDialog.show({					
	                title: 'Error',
	                message: $scope.nopath,
	                size: BootstrapDialog.SIZE_SMALL,
	                type: BootstrapDialog.TYPE_DANGER 
	            }); 
	        });
		}        
		
	}
	
		 $scope.loadTareas = function() {	
		        //var url= $scope.migTaskPath;			 
			 	if($scope.pathMigTask!=""){
			 		var httpRequestTareas = $http.get($scope.pathMigTask)
			        .success(function(data, status) {$scope.listaTareas = data; })
			        .error(function(response) 
			        {
			        	BootstrapDialog.show({					
			                title: 'Error',
			                message: $scope.errorTaskList,
			                size: BootstrapDialog.SIZE_SMALL,
			                type: BootstrapDialog.TYPE_DANGER 
			            }); 
			        });
			 	}             	       
		    };
	
	    $scope.borrarTarea = function(id) {	    		    			 			    	
	    	BootstrapDialog.confirm('¿Está seguro de eliminar el registro?', function(result){
	            if(result) {
	            	if($scope.pathMigTask!=""){
				 		//var httpRequestTareas = $http.delete($scope.pathMigTask+'/'+id)
				 		var httpRequestTareas = $http.delete('/PrasdesClientesConfiguracion/programador'+'/'+id)
				        .success(function(data, status) {
				        	$scope.loadTareas();	   
				        })
				        .error(function(response) 
				        {
				        	BootstrapDialog.show({					
				                title: 'Error',
				                message: $scope.errorTaskList,
				                size: BootstrapDialog.SIZE_SMALL,
				                type: BootstrapDialog.TYPE_DANGER 
				            }); 
				        });
				 	}
	            	         	
	            }
	        });
	    	
		    	
		    	
		    	
	    }
	    

  });