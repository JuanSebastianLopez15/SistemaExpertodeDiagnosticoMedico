
:- dynamic enfermedad/5.


enfermedad(1, gripa, [fiebre, tos, dolor_cabeza, dolor_muscular], viral, [descansar, hidratar, consultar_medico]).
enfermedad(2, covid19, [fiebre, tos, dificultad_respirar, perdida_olfato, perdida_gusto], viral, [aislamiento, hidratar, consultar_medico]).
enfermedad(3, gastritis, [dolor_abdominal, acidez, nausea, vomito], digestiva, [dieta_blanda, antiacidos, consultar_medico]).
enfermedad(4, diabetes, [sed_excesiva, hambre_constante, perdida_peso, fatiga], cronica, [control_glucosa, dieta_equilibrada, actividad_fisica, consultar_medico]).
enfermedad(5, hipertension, [dolor_cabeza, mareo, vision_borrosa, palpitaciones], cronica, [reducir_sal, ejercicio_moderado, controlar_peso, consultar_medico]).


identificar_enfermedad(Sint, Id, Nom) :-
	enfermedad(Id, Nom, Sints, _, _),
	member(Sint, Sints).


coincide_sintomas(SintsBuscados, Nom) :-
	enfermedad(_, Nom, Sints, _, _),
	incluidos(SintsBuscados, Sints).


incluidos([], _).
incluidos([H|T], Lista) :-
	member(H, Lista),
	incluidos(T, Lista).


enfermedades_por_categoria(Cat, Nom, Id) :-
	enfermedad(Id, Nom, _, Cat, _).


enfermedades_cronicas(Nom, Id) :-
	enfermedad(Id, Nom, _, cronica, _).

