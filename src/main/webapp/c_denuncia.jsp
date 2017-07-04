<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Sistema de Controle de Endemias</title>

    <!-- Bootstrap -->
    <link href="vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- Datatables -->
    <link href="vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="build/css/custom.min.css" rel="stylesheet">
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <c:import url="menu.jsp"/>       
        <!-- page content -->
        <div class="right_col" role="main">
          <div class="row">             
          <br />		    
              <div class="row">			  
                <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Denuncias <small>Endemic Sys</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                   <p class="text-muted font-13 m-b-30">
                      <a href="visita.jsp">
                        <button type="button" class="btn btn-success" data-container="body" data-toggle="popover" data-placement="bottom" title="Incluir Novo Funcionário">
                          <i class="fa fa-plus-circle"></i>
                        </button>
                      </a>
                      <a href="c_denuncia.jsp">
                        <button type="button" class="btn btn-primary" data-container="body" data-toggle="popover" data-placement="bottom" title="Limpar Listagem">
                          <i class="fa fa-refresh"></i>
                        </button>
                      </a>					  
                        <button type="submit" class="btn btn-info" data-container="body" data-toggle="popover" data-placement="bottom" title="Buscar">
                          <i class="fa fa-search"></i>
                        </button>
                        <button type="button" class="btn btn-warning" data-container="body" data-toggle="popover" data-placement="bottom" title="Visualizar no Mapa">
                          <i class="fa fa-globe"></i>
                        </button>                       
                    </p>   
                    <table id="datatable-buttons" class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th>Denunciante</th>
                          <th>Data</th>
                          <th>Ações</th>
                        </tr>
                      </thead>


                      <tbody>
                       
                        
                      </tbody>
                    </table>
                  </div>
                  <!-- Small modal -->
                  <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog modal-sm">
                      <div class="modal-content">

                        <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">Ã</span>
                          </button>
                          <h4 class="modal-title" id="myModalLabel2">Confirmação</h4>
                        </div>
                        <div class="modal-body">
                          <p>Deseja realmente executar essa ação?</p>
                        </div>
                        <div class="modal-footer">
                          <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                          <a href="c_funcionario.html"><button type="button" class="btn btn-primary">Sim</button></a>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              </div>  
          </div>
		</div>
		 <footer>
          <div class="pull-center">
            Trabalho PW2017-1 - Sistema de Controle de Endemias <a href="https://github.com/dougfalves/UFG-PW-TRABALHO">GitHub</a>
          </div>
          <div class="clearfix"></div>
        </footer>
      </div>
    </div>

    <!-- jQuery -->
    <script src="vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- Datatables -->
    <script src="vendors/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    <script src="vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
    <script src="vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
    <script src="vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
    <script src="vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
    <script src="vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
    <script src="vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
    <script src="vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
    <script src="vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
    <script src="vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
    <script src="vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
    <script src="vendors/jszip/dist/jszip.min.js"></script>
    <script src="vendors/pdfmake/build/pdfmake.min.js"></script>
    <script src="vendors/pdfmake/build/vfs_fonts.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="build/js/custom.min.js"></script>
	
  </body>
</html>
