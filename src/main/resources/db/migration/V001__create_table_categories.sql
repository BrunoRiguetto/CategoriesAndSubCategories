CREATE TABLE "category" (
    "category_id" uuid PRIMARY KEY DEFAULT (gen_random_uuid()),
    "category_name" varchar(100) NOT NULL,
    "description" varchar(300) NOT NULL
);

CREATE INDEX ON "category" ("category_name");