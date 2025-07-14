# Tarea-SemestralDOO
Grupo 1
Integrantes: Martin Henriquez, Jorge Pedreros, Rodolfo Rubio

Los principales patrones de diseño utilizados durante el proyecto fueron Strategy, Observer y Singleton (para la instancia de ventana).
Strategy fue utilizado en las clases Calendario, Participantes, MenuVerTorneo, todas con el objetivo de variar la forma en la que se comportan dependiendo del tipo de torneo en el que se está trabajando.
En el caso de la clase Calendario, se creó la interfaz TipoDeCalendario, con las estrategias CalendarioElimDirecta, CalendarioElimDoble y CalendarioXPuntos, este patrón de diseñó se utilizó principalmente por la variación en la forma en la que debían realizarse los Enfrentamientos en cada tipo de Torneo, por ejemplo, CalendarioXPuntos está asociado a la Liga y permite crear jornadas en la forma en la que lo haria una tabla de cruces, luego CalendarioElimDirecta y CalendarioElimDoble se rigen principalmente por los resultados de jorndas previas para crear los enfrentamientos.
En la implementación de strategy de Participantes, se crearon las estrategias AgrupacionElimDirecta, AgrupacionElimDoble y AgrupacionLiga, que implementan la interfaz AgrupacionParticipantes, con el fin de variar la forma en la que cada Participante interactua en el momento en que pertenece al torneo. AgrupacionElimDirecta y AgrupacionElimDoble, asignan a cada Participante a un Bracket y verifican que este siga en el torneo antes de devolver un ArrayList de estos. AgrupacionLiga, por su parte, ordena a los participantes dependiendo de los puntos que cada uno tenga, para simular la clasificacion de esta.
MenuVerTorneo utiliza las estrategias PanelELiminacionDirecta, PanelEliminacionDoble y PanelLiga, las cuales implementan la interfaz PanelTorneo. Cada estrategia varia la forma en la que cada participante se ve representado en la interfaz gráfica, ya sea dentro de una tabla de clasificacion o una simulacion de bracket.
El patron Observer es utilizado por cada Participante para ver el resultado de cada enfrentamiento y actualizar sus estadisticas.

Las principales decisiones tomadas respecto al desarrollo del proyecto están principalmente relacionadas a los patrones utilizados, los cuales permitieron versatilizar la implementación de una forma mucha más simple. Otra decisión clave fue limitar aspectos que podrian llevar a una implementación poco clara y propensa a fallas, lo que fue compensado volviendo mas estrictas las opciones de uso mediantes la implementacion de diversas Enumeraciones. Respecto a la implementacion gráfica, la decisicion más importante fue trabajar con una instancia static de torneo, lo que permitia acceder sin tanta complejidad a esta desde los demás metodos gráficos.

La principal autocritica que tenemos como grupo va relacionada con el manejo de los tiempos entre otras responsabilidades con la realizacion del proyecto, lo que llevó a que muchas de las ideas pensadas en un principio no fueran implementadas de manera, y que otras terminaran con fallos o incompletas.



Diagrama de casos de uso:

<img width="690" height="721" alt="Diagrama Casos de Uso" src="https://github.com/user-attachments/assets/18c657d1-41ac-409c-a71a-2e67db8f1a6b" />

