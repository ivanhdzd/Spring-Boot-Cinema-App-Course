DROP DATABASE IF EXISTS cinema_app;

CREATE DATABASE cinema_app;

USE cinema_app;

CREATE TABLE details (
	id INT(8) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	director VARCHAR(64) DEFAULT NULL,
	actors VARCHAR(256) DEFAULT NULL,
	synopsis TEXT,
	trailer VARCHAR(256) DEFAULT NULL COMMENT 'Youtube trailer URL'
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE movies (
	id INT(8) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	id_detail INT(8) DEFAULT NULL,
	title VARCHAR(64) NOT NULL,
	duration INT(4) NOT NULL,
	classification ENUM('A', 'B', 'C') NOT NULL DEFAULT 'A',
	genre VARCHAR(64) NOT NULL,
	premiere_date DATE NOT NULL,
	image VARCHAR(128) NOT NULL DEFAULT 'cinema.png',
	status ENUM('ACTIVE', 'INACTIVE') NOT NULL DEFAULT 'ACTIVE',
	FOREIGN KEY (id_detail) REFERENCES details(id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE timetables (
	id INT(8) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	id_movie INT(8) NOT NULL,
	date DATE NOT NULL,
	time TIME NOT NULL,
	room VARCHAR(64) NOT NULL DEFAULT 'Room 1',
	price DOUBLE NOT NULL DEFAULT 0,
	FOREIGN KEY (id_movie) REFERENCES movies(id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE banners (
	id INT(8) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(64) NOT NULL,
	date DATE NOT NULL,
	image VARCHAR(128) NOT NULL,
	status ENUM('ACTIVE', 'INACTIVE') NOT NULL DEFAULT 'ACTIVE'
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE news (
	id INT(8) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(64) NOT NULL,
	publication_date DATE NOT NULL,
	status ENUM('ACTIVE', 'INACTIVE') NOT NULL DEFAULT 'ACTIVE',
	details TEXT NOT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE users (
	id INT(8) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(32) NOT NULL UNIQUE KEY,
	name VARCHAR(64) NOT NULL,
	email VARCHAR(64) NOT NULL,
	password VARCHAR(256) NOT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE user_profiles (
	id INT(8) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(32) NOT NULL,
	profile VARCHAR(256) NOT NULL,
	FOREIGN KEY (username) REFERENCES users(username)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO details VALUES
	(1, 'Jordan Vogt-Roberts', 'Samuel L. Jackson, Tom Hiddleston, Brie Larson, Toby Kebbell', 'Kong: La Isla Calavera reimagina el origen del mítico Kong en una irresistible aventura original del director Jordan Vogt-Roberts. En la película, un diverso equipo de exploradores es reunido para aventurarse en el interior de una isla del Pacífico —tan bella como traicionera— que no aparece en los mapas, sin saber que están invadiendo los dominios del mítico Kong.', 'https://www.youtube.com/embed/86jhW2gPc84'),
	(2, 'Daniel Espinosa', 'Jake Gyllenhaal, Ryan Reynolds, Rebecca Ferguson', 'Seis miembros de la tripulación de la Estación Espacial Internacional que están a punto de lograr uno de los descubrimientos más importantes en la historia humana: la primera evidencia de vida extraterrestre en Marte. A medida que el equipo comienza a investigar y sus métodos tienen consecuencias inesperadas, la forma viviente demostrará ser más inteligente de lo que cualquiera esperaba.', 'https://www.youtube.com/embed/_cq1XIVXdjU'),
	(3, 'Bill Condon', 'Dan Stevens, Emma Watson, Luke Evans', 'LA BELLA Y LA BESTIA, de Disney, es una adaptación de acción real de la película animada, que revive a los queridos personajes del clásico cuento de Disney para una audiencia contemporánea, manteniendo la música original e incorporando varias nuevas canciones.', 'https://www.youtube.com/embed/4D8N06nx9rs'),
	(4, 'Oriol Paulo', 'Mario Casas, Bárbara Lennie, José Coronado, Ana Wagener', 'Adrián Doria, un joven y exitoso empresario, despierta en la habitación de un hotel junto al cadáver de su amante. Acusado de asesinato, decide contratar los servicios de Virginia Goodman, la mejor preparadora de testigos del país. En el transcurso de una noche, asesora y cliente trabajarán para encontrar una duda razonable que le libre de la cárcel.', 'https://www.youtube.com/embed/sOxy2gtPY7A'),
	(5, 'Dean Israelite', 'Bryan Cranston, Elizabeth Banks, Becky G, Dacre Montgomery', 'Cinco adolescentes deben convertirse en algo extraordinario al enterarse que su pueblo, Angel Grove, y el mundo están a punto de ser aniquilados por una amenaza extraterrestre. Escogidos por el destino, nuestros héroes pronto descubren que son los únicos que pueden salvar el planeta…pero para hacerlo, deberán superar sus problemas de la vida real y, antes que sea demasiado tarde, unirse como los PowerRangers.', 'https://www.youtube.com/embed/gemUEi0XMTg'),
	(6, 'F. Gary Gray', 'Dwayne Johnson, Michelle Rodriguez, Charlize Theron, Jason Statham, Vin Diesel', 'Justo cuando Dom y Letty celebran su luna de miel, Brian y Mia se han retirado del juego y el resto del equipo se ha desintegrado en busca de una vida comun y corriente; una misteriosa mujer intentara seducir a Dom para convencerlo de regresar a la vida criminal que tanto lo acecha, traicionando a quienes lo rodean y enfrentandose a retos nunca antes vistos.', 'https://www.youtube.com/embed/3KuazYQ1JuE'),
	(7, 'James Gunn', 'Dave Bautista, Bradley Cooper, Zoe Saldana, Vin Diesel, Chris Pratt', 'Ambientada en el nuevo contexto sonoro de \"Awesome Mixtape #2\", GUARDIANES DE LA GALAXIA VOL. 2, de Marvel, continua las aventuras del equipo en su travesia por los confines del cosmos. Los Guardianes deberan luchar para mantener unida a su nueva familia mientras intentan resolver el misterio del verdadero linaje de Peter Quill. Viejos rivales se convertiran en nuevos aliados y los personajes favoritos de los comics clasicos acudiran en ayuda de nuestros heroes a medida que el Universo Cinematografico de Marvel continua expandiendose.', 'https://www.youtube.com/embed/bBTtlcJwjSo');

INSERT INTO movies VALUES
	(1, 1, 'Kong La Isla Calavera', 118, 'B', 'Action', '2018-03-07', 'kong.png', 'ACTIVE'),
	(2, 2, 'Life: Vida Inteligente', 104, 'B', 'Drama', '2018-03-07', 'life.png', 'ACTIVE'),
	(3, 3, 'La Bella y La Bestia', 132, 'A', 'Childish', '2018-03-07', 'bella.png', 'ACTIVE'),
	(4, 4, 'Contratiempo', 106, 'B', 'Thriller', '2018-03-09', 'contratiempo.png', 'ACTIVE'),
	(5, 5, 'Power Rangers', 120, 'B', 'Adventure', '2018-03-09', 'power-rangers.png', 'ACTIVE'),
	(6, 6, 'Rapidos y Furiosos 8', 136, 'B', 'Action', '2018-03-11', 'rapidos-furiosos.png', 'ACTIVE'),
	(7, 7, 'Guardianes de la Galaxia Vol 2', 136, 'B', 'Action', '2018-03-11', 'guardianes-galaxia.png', 'ACTIVE');

INSERT INTO news (id, title, publication_date, details, status) VALUES
	(1,"La Liga de la Justicia","2017-09-01","El estreno en cines de la película 'La Liga de la Justicia' se presenta como uno de los de mayor interés dentro del género de superhéroes de cómic","ACTIVE"),
	(2,"Star Wars Episodio 8","2017-09-01","Llega un nuevo cartel de la película 'Star Wars Episodio 8'. Con dos de sus personajes principales. Kylo y Rey, interpretados por Adam Driver y Daisy Ridl","ACTIVE"),
	(3,"Blade Runner 2","2017-09-01","La actriz Robin Wright es una de las novedades más llamativas dentro del argumento de la secuela de Blade Runner.","ACTIVE"),
	(4,"Rocky Creed 2","2017-09-01","El proceso de rodaje de la película 'Rocky Creed 2' comenzó hace unos días. Ahora podemos ver el nuevo e impactante aspecto de Sylvester Stallone","INACTIVE"),
	(5,"Hellboy 3","2017-09-02","Con el rodaje de la película 'Hellboy 3' a punto de dar comienzo, es el momento de ver la primera sinopsis del filme protagonizado por el actor David Harb","INACTIVE"),
	(6,"Indiana Jones 5","2017-09-02","Hace unos meses se barajaba la posibilidad de que el actor Shia LaBeouf regresara, al menos a modo de cameo, a la saga Indiana Jones en su quinta entrega. ","ACTIVE"),
	(7,"Aquaman","2017-09-02","El futuro del universo DC se basa en gran medida gracias a títulos como 'Aquaman'. ","ACTIVE"),
	(8,"Thor 3","2017-09-02","Continúan las novedades de la película de Marvel 'Thor 3 Ragnarok'. Ahora con un cartel de Hulk, personaje de gran relevancia en la tercera entrega ","INACTIVE"),
	(9,"Los Vengadores 4","2017-09-03","Karen Gillan comparte vistazo de rodaje desde la tercera y cuarta película","ACTIVE"),
	(10,"Star Wars Han Solo","2017-09-03","Primera imagen de de Paul Bettany en el rodaje","ACTIVE"),
	(11,"Escuadrón Suicida 2","2017-09-03","Margot Robbie confirma el rodaje para principios de 2018","ACTIVE"),
	(12,"La Guerra del Planeta de los Simios","2017-09-04","La película de ciencia ficción 'La Guerra del Planeta de los Simios' se sitúa en la carrera hacia los Oscar 2018 de Hollywood.","INACTIVE"),
	(13,"Maléfica 2","2017-09-04","El proyecto de 'Maléfica 2' cobra nueva vida con la llegada de Jez Butterworth para ocuparse de la nueva versión del guión. ","ACTIVE"),
	(14,"Top Gun 2","2017-09-04","La película 'Top Gun 2' retrasa su estreno en cines. Todo tras el cambio de guionista dentro de la producción protagonizada por Tom Cruise. ","ACTIVE"),
	(15,"American Made","2017-09-04","El actor Tom Cruise encabeza los estrenos de cine del fin de semana con la cinta American Made","ACTIVE"),
	(16,"Ant Man 2","2017-09-04","Llega la primera imagen oficial de la película 'Ant Man 2' con la actriz Evangeline Lilly con el traje de la Avispa en la secuela de Marvel","ACTIVE"),
	(17,"Secret Service 2","2017-09-05","Llega un nuevo vídeo de la película de acción 'Secret Service 2'. Contando con un buen número de escenas inéditas de la adaptación de la obra de Mark","INACTIVE"),
	(18,"El Otro Guardaespaldas","2017-09-06","Confirma su éxito en los Estados Unidos repitiendo en lo más alto de la taquilla","ACTIVE"),
	(19,"Valerian","2017-09-06","Lidera la taquilla de cine en España en su estreno","INACTIVE"),
	(20,"Madre","2017-09-06","La película 'Madre', dirigida por el cineasta Darren Aronofsky y protagonizada por Jennifer Lawrence y Javier Bardem, llega ahora con su cartel final","ACTIVE"),
	(21,"Tony Gilroy dirigirá Matusalén","2017-09-07","Warner Bros. Pictures ha iniciado las negociaciones con Tony Gilroy (High Wire Act) para que escriba y dirija un thriller conocido hasta el momento como Methuselah.","ACTIVE"),
	(22,"Guionista para Maléfica 2","2017-09-07","Disney Pictures ha contratado a Jez Butterworth ( I Feel Good) para que re-escriba el guión de la secuela de Maléfica.","ACTIVE"),
	(23,"Jon Bernthal se une a First Man","2017-09-07","Jon Bernthal (Baby Driver) se pondrá a las órdenes de Damien Chazelle en la película de Universal Pictures y Amblin Entertainment First Man.","INACTIVE"),
	(24,"Barry Seal: El traficante","2017-09-07","El proximo mes se estrena la pelicula Barry Seal: El traficante. Nuevamente veremos a Tom Cruise.","ACTIVE"),
	(25,"Ben Affleck podría dirigir Red Platoon","2017-09-08","Ben Affleck (Liga de la justicia) ha iniciado las conversaciones con Sony Pictures, Immersive Pictures y Smokehouse Pictures para dirigir el drama bélico Red Platoon.","ACTIVE"),
	(26,"Disney prepara una película sobre Obi-Wan Kenobi","2017-09-08","Disney y Lucasfilm está preparando un nuevo spin-off de Star Wars, esa vez centrado en el personaje de Obi-Wan Kenobi.","INACTIVE"),
	(27,"Primer vistazo a Cable y Domino en Deadpool 2","2017-09-08","Se han publicado en las redes sociales las primeras fotografías de Zazie Beetz en el papel de Neena Thurman / Domino y Josh Brolin como Cable en la esperada Deadpool 2.","ACTIVE"),
	(28,"Pedro Pascal se une a The Equalizer 2","2017-09-08","Pedro Pascal (La Gran Muralla) participará en la secuela de la película de Sony Pictures The Equalizer: El Protector.","ACTIVE"),
	(29,"Más reparto para Skyscraper","2017-09-08","Chin Han (Ghost In the Shell) acompañará a Dwayne Johnson en el thriller de acción de Legendary Skyscraper.","INACTIVE"),
	(30,"Fecha para Wonder Woman 2","2017-09-08","Warner Bros. Pictures ha puesto fecha de estreno a la secuela de Wonder Woman, que volverá a estar protagonizada por Gal Gadot en el papel de la famosa heroína.","ACTIVE");

INSERT INTO timetables (id_movie, date, time, room, price) VALUES
	(1, NOW(), '17:30', 'Room Premium', 50),
	(1, NOW(), '19:00', 'Room 1', 50),
	(1, DATE_ADD(NOW(), INTERVAL 1 DAY), '17:30', 'Room 2', 50),
	(1, DATE_ADD(NOW(), INTERVAL 1 DAY), '19:00', 'Room 3', 50),
	(1, DATE_ADD(NOW(), INTERVAL 2 DAY), '17:30', 'Room Premium', 50),
	(1, DATE_ADD(NOW(), INTERVAL 2 DAY), '19:00', 'Room 1', 50),
	(1, DATE_ADD(NOW(), INTERVAL 3 DAY), '17:30', 'Room 2', 50),
	(1, DATE_ADD(NOW(), INTERVAL 3 DAY), '19:00', 'Room 3', 50),
	(1, DATE_ADD(NOW(), INTERVAL 4 DAY), '17:30', 'Room Premium', 50),
	(1, DATE_ADD(NOW(), INTERVAL 4 DAY), '19:00', 'Room 1', 50),
	(2, NOW(), '17:30', 'Room Premium', 50),
	(2, NOW(), '19:00', 'Room 1', 50),
	(2, DATE_ADD(NOW(), INTERVAL 1 DAY), '17:30', 'Room 2', 50),
	(2, DATE_ADD(NOW(), INTERVAL 1 DAY), '19:00', 'Room 3', 50),
	(2, DATE_ADD(NOW(), INTERVAL 2 DAY), '17:30', 'Room Premium', 50),
	(2, DATE_ADD(NOW(), INTERVAL 2 DAY), '19:00', 'Room 1', 50),
	(2, DATE_ADD(NOW(), INTERVAL 3 DAY), '17:30', 'Room 2', 50),
	(2, DATE_ADD(NOW(), INTERVAL 3 DAY), '19:00', 'Room 3', 50),
	(2, DATE_ADD(NOW(), INTERVAL 4 DAY), '17:30', 'Room Premium', 50),
	(2, DATE_ADD(NOW(), INTERVAL 4 DAY), '19:00', 'Room 1', 50),
	(3, NOW(), '17:30', 'Room Premium', 50),
	(3, NOW(), '19:00', 'Room 1', 50),
	(3, DATE_ADD(NOW(), INTERVAL 1 DAY), '17:30', 'Room 2', 50),
	(3, DATE_ADD(NOW(), INTERVAL 1 DAY), '19:00', 'Room 3', 50),
	(3, DATE_ADD(NOW(), INTERVAL 2 DAY), '17:30', 'Room Premium', 50),
	(3, DATE_ADD(NOW(), INTERVAL 2 DAY), '19:00', 'Room 1', 50),
	(3, DATE_ADD(NOW(), INTERVAL 3 DAY), '17:30', 'Room 2', 50),
	(3, DATE_ADD(NOW(), INTERVAL 3 DAY), '19:00', 'Room 3', 50),
	(3, DATE_ADD(NOW(), INTERVAL 4 DAY), '17:30', 'Room Premium', 50),
	(3, DATE_ADD(NOW(), INTERVAL 4 DAY), '19:00', 'Room 1', 50),
	(4, NOW(), '17:30', 'Room Premium', 50),
	(4, NOW(), '19:00', 'Room 1', 50),
	(4, DATE_ADD(NOW(), INTERVAL 1 DAY), '17:30', 'Room 2', 50),
	(4, DATE_ADD(NOW(), INTERVAL 1 DAY), '19:00', 'Room 3', 50),
	(4, DATE_ADD(NOW(), INTERVAL 2 DAY), '17:30', 'Room Premium', 50),
	(4, DATE_ADD(NOW(), INTERVAL 2 DAY), '19:00', 'Room 1', 50),
	(4, DATE_ADD(NOW(), INTERVAL 3 DAY), '17:30', 'Room 2', 50),
	(4, DATE_ADD(NOW(), INTERVAL 3 DAY), '19:00', 'Room 3', 50),
	(4, DATE_ADD(NOW(), INTERVAL 4 DAY), '17:30', 'Room Premium', 50),
	(4, DATE_ADD(NOW(), INTERVAL 4 DAY), '19:00', 'Room 1', 50),
	(5, NOW(), '17:30', 'Room Premium', 50),
	(5, NOW(), '19:00', 'Room 1', 50),
	(5, DATE_ADD(NOW(), INTERVAL 1 DAY), '17:30', 'Room 2', 50),
	(5, DATE_ADD(NOW(), INTERVAL 1 DAY), '19:00', 'Room 3', 50),
	(5, DATE_ADD(NOW(), INTERVAL 2 DAY), '17:30', 'Room Premium', 50),
	(5, DATE_ADD(NOW(), INTERVAL 2 DAY), '19:00', 'Room 1', 50),
	(5, DATE_ADD(NOW(), INTERVAL 3 DAY), '17:30', 'Room 2', 50),
	(5, DATE_ADD(NOW(), INTERVAL 3 DAY), '19:00', 'Room 3', 50),
	(5, DATE_ADD(NOW(), INTERVAL 4 DAY), '17:30', 'Room Premium', 50),
	(5, DATE_ADD(NOW(), INTERVAL 4 DAY), '19:00', 'Room 1', 50),
	(6, NOW(), '17:30', 'Room Premium', 50),
	(6, NOW(), '19:00', 'Room 1', 50),
	(6, DATE_ADD(NOW(), INTERVAL 1 DAY), '17:30', 'Room 2', 50),
	(6, DATE_ADD(NOW(), INTERVAL 1 DAY), '19:00', 'Room 3', 50),
	(6, DATE_ADD(NOW(), INTERVAL 2 DAY), '17:30', 'Room Premium', 50),
	(6, DATE_ADD(NOW(), INTERVAL 2 DAY), '19:00', 'Room 1', 50),
	(6, DATE_ADD(NOW(), INTERVAL 3 DAY), '17:30', 'Room 2', 50),
	(6, DATE_ADD(NOW(), INTERVAL 3 DAY), '19:00', 'Room 3', 50),
	(6, DATE_ADD(NOW(), INTERVAL 4 DAY), '17:30', 'Room Premium', 50),
	(6, DATE_ADD(NOW(), INTERVAL 4 DAY), '19:00', 'Room 1', 50),
	(7, NOW(), '17:30', 'Room Premium', 50),
	(7, NOW(), '19:00', 'Room 1', 50),
	(7, DATE_ADD(NOW(), INTERVAL 1 DAY), '17:30', 'Room 2', 50),
	(7, DATE_ADD(NOW(), INTERVAL 1 DAY), '19:00', 'Room 3', 50),
	(7, DATE_ADD(NOW(), INTERVAL 2 DAY), '17:30', 'Room Premium', 50),
	(7, DATE_ADD(NOW(), INTERVAL 2 DAY), '19:00', 'Room 1', 50),
	(7, DATE_ADD(NOW(), INTERVAL 3 DAY), '17:30', 'Room 2', 50),
	(7, DATE_ADD(NOW(), INTERVAL 3 DAY), '19:00', 'Room 3', 50),
	(7, DATE_ADD(NOW(), INTERVAL 4 DAY), '17:30', 'Room Premium', 50),
	(7, DATE_ADD(NOW(), INTERVAL 4 DAY), '19:00', 'Room 1', 50);
