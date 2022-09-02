<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="css/commun.css">
	
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
		        <a  href="index.jsp" class="navbar-brand active">
		        <span class="glyphicon glyphicon-film"></span> 
		        <span class="glyphicon glyphicon-film"></span> 
		        </a>
		          <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		          </button>
		    </div>
			<div class="navbar-collapse collapse" id="navbar-main">
				<ul class="nav navbar-nav navbar-right">
					<li ><a href="index.jsp">Accueil</a></li>
					<li><a href="lister">Liste des films</a></li>
					<li><a href="ajouter">Ajouter un film</a></li>
					<li><a href="listerStyle">Styles</a></li>
					<li><a href="geo.jsp">Qui sommes-nous</a></li>
				</ul>
			</div>
		</div>
	</nav>	
	
<div class="container">	
	<h1 class="bleu">Votre film</h1>
	<br><br>
		<div>
	<form class="form-horizontal" >
				<div class="form-group">			
					<label for="titre" class="col-xs-2 control-label">Titre :</label>
					<div class="col-xs-10">
						<input id="titre"  value="${film.titre }" readonly   class="form-control" /> 
					</div>
				</div>

				<div class="form-group">			
					<label for="annee" class="col-xs-2 control-label">Année :</label>
					<div class="col-xs-10">
						<input id="annee"  value="${film.annee }" readonly    class="form-control" /> 
					</div>
				</div>

				<div class="form-group">			
					<label for="style" class="col-xs-2 control-label">Style :</label>
					<div class="col-xs-10">
						<input id="style"  value="${film.style.libelle }" readonly    class="form-control" /> 
					</div>
				</div>
				<div class="form-group">			
					<label for="real" class="col-xs-2 control-label">Réalisateur :</label>
					<div class="col-xs-5">
						<input id="real" value="${film.real.prenom}" readonly   class="form-control" /> 
					</div>
					<div class="col-xs-5">
						<input value="${film.real.nom}"   readonly class="form-control" /> 
					</div>
				</div>

				<div class="form-group">			
					<label for="duree" class="col-xs-2 control-label">Durée :</label>
					<div class="col-xs-10">
						<input id="duree" value="${film.duree}"  readonly   class="form-control" /> 
					</div>
				</div>


				<div class="form-group">			
					<label for="vu" class="col-xs-2 control-label">Vu :</label>
					<div class="col-xs-10">
						<input id="vu" value="${film.vu?'Oui':'Non'}" readonly   class="form-control" /> 
					</div>
				</div>


				<c:forEach items="${ film.acteurs}" var="act" varStatus="status">
					<div class="form-group">			
						<label for="acteur${status.index}" class="col-xs-2 control-label">Acteur ${status.index + 1} :</label>
						<div class="col-xs-5">
							<input id="acteur${status.index}" readonly value="${act.prenom}"   class="form-control"/>
						</div>
						<div class="col-xs-5">
							<input readonly value="${act.nom}"  class="form-control"/>
						</div>
					</div>
				</c:forEach>

				<div class="form-group">			
					<label for="synopsis" class="col-xs-2 control-label">Synopsis :</label>
					<div class="col-xs-10">
						<textarea id="synopsis"  rows="5" readonly  class="form-control" >${film.synopsis}</textarea> 
					</div>
				</div>
			
	</form>
	</div>
</div>
	
</body>
</html>