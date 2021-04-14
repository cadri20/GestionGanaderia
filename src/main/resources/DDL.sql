/**
 * Author:  cadri
 * Created: 14/04/2021
 */
CREATE TABLE "finca" (
	"ID"	INTEGER NOT NULL,
	"nombre_finca"	TEXT NOT NULL,
	"hectareas"	REAL,
	"ubicacion"	TEXT,
	"path_foto"	TEXT,
	PRIMARY KEY("ID" AUTOINCREMENT)
);

CREATE TABLE "animal" (
	"id_animal"	TEXT NOT NULL,
	"id_finca"	TEXT,
	"nombre_animal"	TEXT NOT NULL,
	"fecha_ingreso"	TEXT,
	"fecha_nacimiento"	INTEGER,
	"tipo"	TEXT NOT NULL,
	"costo"	REAL,
	"color"	TEXT,
	"id_padre"	TEXT,
	"id_madre"	TEXT,
	PRIMARY KEY("id_animal"),
	FOREIGN KEY("id_finca") REFERENCES "finca"("ID") ON DELETE CASCADE,
	FOREIGN KEY("id_padre") REFERENCES "animal"("id_animal"),
	FOREIGN KEY("id_madre") REFERENCES "animal"("id_animal")
);

CREATE TABLE "tratamiento" (
	"id_animal"	TEXT NOT NULL,
	"fecha"	TEXT NOT NULL,
	"descripcion"	TEXT NOT NULL,
	"producto_utilizado"	TEXT,
	FOREIGN KEY("id_animal") REFERENCES "animal"("id_animal") ON DELETE CASCADE
);

CREATE TABLE "imagen_animal" (
	"id_animal"	TEXT NOT NULL,
	"path"	TEXT NOT NULL,
	PRIMARY KEY("id_animal","path"),
	FOREIGN KEY("id_animal") REFERENCES "animal"("id_animal") ON DELETE CASCADE
);


