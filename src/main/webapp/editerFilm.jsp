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
	<h1 class="bleu">Edition d'un film</h1>
	<br><br>
		<div>
	<form action="editer" method="POST" class="form-horizontal" >
				<input type="hidden" name="id" value="${film.id}" /> 
				<div class="form-group">			
					<label for="titre" class="col-xs-2 control-label">Titre :</label>
					<div class="col-xs-10">
						<input id="titre" name="titre" value="${film.titre}"  placeholder="Titre du film ..."  class="form-control" /> 
					</div>
				</div>

				<div class="form-group">			
					<label for="annee" class="col-xs-2 control-label">Année :</label>
					<div class="col-xs-10">
						<input id="annee" name="annee" value="${film.annee}"  placeholder="Année de sortie ..."  class="form-control" /> 
					</div>
				</div>

				<div class="form-group">			
					<label for="style.id" class="col-xs-2 control-label">Style :</label>
					<div class="col-xs-10">
						<select name = "style" id="style" class="form-control">
						<c:forEach items="${listeStyles}" var="s">
							<option value="${s.id}" ${s.id == film.style.id ? "selected" : ""}>${s.libelle}</option>
						</c:forEach>
						</select>					
					</div>
				</div>
				<div class="form-group">			
					<label for="real.prenom" class="col-xs-2 control-label">Réalisateur :</label>
					<div class="col-xs-5">
						<input id="real.prenom"  name="real.prenom" value="${film.real.prenom}" placeholder="Prénom ..."  class="form-control" /> 
					</div>
					<div class="col-xs-5">
						<input name="real.nom"  value="${film.real.nom}" placeholder="Nom ..."  class="form-control" /> 
					</div>
				</div>

				<div class="form-group">			
					<label for="duree" class="col-xs-2 control-label">Durée :</label>
					<div class="col-xs-10">
						<input id="duree"  name="duree"  value="${film.duree}" placeholder="Durée du film (format h:mm) ..."  class="form-control" /> 
					</div>
				</div>


				<div class="form-group">			
					<label for="vu" class="col-xs-2 control-label">Vu :</label>
					<div class="col-xs-10">
						<select name = "vu" id="vu" class="form-control">
							<option value="true" ${film.vu ? "selected" : ""}>Oui</option>
							<option value="false"${film.vu ? "" : "selected"}>Non</option>
						</select>					
					</div>
				</div>

<%-- 				<c:forEach items="${ film.acteurs}" var="acteur" varStatus="status"> --%>
<!-- 					<div class="form-group">			 -->
<%-- 						<label for="duree" class="col-xs-2 control-label">Acteur ${status.index + 1} :</label> --%>
<!-- 						<div class="col-xs-5"> -->
<%-- 							<input name="prenom${status.index}" value="${acteur.prenom}"  placeholder="Prénom ..." class="form-control"/> --%>
<!-- 						</div> -->
<!-- 						<div class="col-xs-5"> -->
<%-- 							<input name="nom${status.index}" value="${acteur.nom}"  placeholder="Nom ..." class="form-control"/> --%>
<!-- 						</div> -->
<!-- 					</div> -->
<%-- 				</c:forEach> --%>

				<c:forEach begin="0" end="4" var="ind">
					<div class="form-group">			
						<label for="prenom${ind}" class="col-xs-2 control-label">Acteur ${ind + 1} :</label>
						<div class="col-xs-5">
							<input id ="prenom${ind}" name="prenom${ind}" value="${film.acteurs[ind].prenom}" placeholder="Prénom ..." class="form-control"/>
						</div>
						<div class="col-xs-5">
							<input name ="nom${ind}" value="${film.acteurs[ind].nom}" placeholder="Nom ..." class="form-control"/>
						</div>
					</div>
				</c:forEach>

				<div class="form-group">			
					<label for="synopsis" class="col-xs-2 control-label">Synopsis :</label>
					<div class="col-xs-10">
						<textarea id="synopsis" name="synopsis" rows="5" placeholder="Résumé et commentaires ..."  class="form-control" >${film.synopsis}</textarea> 
					</div>
				</div>

				<div class="form-group" >
					<div class="col-xs-offset-2 col-xs-10">
						<button type="submit" class="btn btn-primary">Envoyer</button>			
					</div>
				</div>	
			
	</form>
	</div>
</div>
	
</body>
</html>