
let titres = ['Star Wars', 'Retour vers le futur', 'Interstellar', 'Le Seigneur des Anneaux', 'Blade Runner', 'Le grand blond avec une chaussure noire', 'Premier contact'];
let noms = ['CASSIN', 'CHARRIER', 'ABERBACHE', 'MUGNIERY', 'REDOUANE', 'DINOIR-LABRUX', 'DEMOLEON', 'LAVIALE', 'TEILLET', 'GAUTHIER'];
let prenoms = ['Etienne', 'Régis', 'Valentin', 'Jean', 'Abdel', 'Thierry', 'Mickaël', 'Clara', 'Quentin', 'Maud'];
let synopsis = ['Un super commentaire', 'Un film vraiment trop cool', 'Un commentaire parfaitement objectif', 'Un commentaire absolument pas objectif', 'Et bla bla bla'];

function autopopulate() {
	var input_titre = document.getElementById('titre');
	var input_annee = document.getElementById('annee');
	var input_real_prenom = document.getElementById('real.prenom');
	var input_real_nom = document.getElementById('real.nom');
	var input_duree = document.getElementById('duree');
	var ta_synopsis = document.getElementById('synopsis');
	
	input_titre.value = titres[random(0, titres.length)];
	input_annee.value = random(1900, 2025);
	input_real_prenom.value = prenoms[random(0, prenoms.length)];
	input_real_nom.value = noms[random(0, noms.length)];
	input_duree.value = random(5, 180);
	ta_synopsis.innerHTML = synopsis[random(0, synopsis.length)];
	
	var nb_acteurs = random(1, 6);
	for (i = 0; i < nb_acteurs; i++) {
		var input_acteur_prenom = document.getElementById('prenom' + i);
		var input_acteur_nom = document.getElementById('nom' + i);
		input_acteur_prenom.value = prenoms[random(0, prenoms.length)];
		input_acteur_nom.value = noms[random(0, noms.length)];
	}
	for (i = nb_acteurs; i < 5; i++) {
		var input_acteur_prenom = document.getElementById('prenom' + i);
		var input_acteur_nom = document.getElementById('nom' + i);
		input_acteur_prenom.value = '';
		input_acteur_nom.value = '';
	}
	
}

function random(min, max) {
	return Math.floor(Math.random() * (max-min)) + min;
}