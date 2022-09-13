CREATE TABLE `tb_movies` (
	`id`         BIGINT          NOT NULL AUTO_INCREMENT,
    `name`       VARCHAR(40)     NOT NULL,
    `genre`      VARCHAR(20)     NOT NULL,
    `url_stream` VARCHAR(50)     NOT NULL,
    PRIMARY KEY(`id`)
);