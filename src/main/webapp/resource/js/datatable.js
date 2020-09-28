// DO NOT REMOVE : GLOBAL FUNCTIONS!
		
		$(document).ready(function() {
			
			pageSetUp();
			
			$(document).ready(function () {
	            $('#result-table').DataTable({
	                dom: 'Bfrtip',
	                
	                buttons: [
	                   
	                    {
	                        extend: 'collection',
 	                        className     : 'fa fa-download',
	                        text: '   Exportar consulta',
	                        buttons: [
	                        	 {
	     	                        extend: 'pdfHtml5',
	     	                        orientation: 'portrait',
	     	                        text : 'PDF',
	                             	title: 'Relatório de consulta',
	     	                        exportOptions: {
	     	                            columns: ':visible'
	     	                        }
	     	                    },
	     	                    
	     	                    {
	     	                        extend: 'excel',
	     	                        text : 'Excel',
	     	                        exportOptions: {
	     	                            columns: ':visible'
	     	                        }
	     	                    },
	     	                    {
	     	                        extend: 'csv',
	     	                        text : 'CSV',
	     	                        exportOptions: {
	     	                            columns: ':visible'
	     	                        }
	     	                    }
	                            
	                        ],
	                        fade: 200
	                    },
 	                    {
 	                        extend: 'copy',
 	                        className     : 'fa fa-clone',
 	                        text : '   Copiar',
 	                        exportOptions: {
 	                            columns: ':visible'
 	                        }
 	                    },
 	                    {
 	                        extend: 'colvis',
 	                        className     : 'fa fa-table',
 	                        text : '   Editar colunas',
 	                        exportOptions: {
 	                            columns: ':visible'
 	                        }
 	                    },
	                    {
	                        extend: 'pageLength',
	                        className     : 'fa fa-list-ol',
	                        exportOptions: {
	                            columns: ':visible'
	                        }
	                    }
	                ],
	                language: {
		                url: "//cdn.datatables.net/plug-ins/1.10.15/i18n/Portuguese-Brasil.json",
		                buttons: {
		                    colvis: 'Mostrar colunas',
		                    copy: 'Copiar',
	                    	pageLength: '	Quantidade'

		                }
		            },
		            colReorder: true,
		            
		            
	            });

	        });
		
		})
