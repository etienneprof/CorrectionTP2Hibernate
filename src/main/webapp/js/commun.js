$(function(){
	$(".supp").on("click", function(){
		let att = $(this).attr("id");
		let rep = confirm("Voulez-vous supprimer l'élément ?");
		if (rep)
			window.location="supprimer?index=" + att;
	});
	
	$(".modif").on("click", function(){
		let att = $(this).attr("id");
		window.location="editer?index=" + att;
	});
});