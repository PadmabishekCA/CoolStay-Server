CREATE TABLE `user_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `rolename` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `t_mst_slot` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Intreval` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `t_mst_slot` VALUES (1,'10Am to 10:30Am'),(2,'10:30Am to 11:00Am'),(3,'11:00 Am to 11:30 Am'),(4,'11:30 Am to 12:00 Am');

CREATE TABLE `t_mst_games` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `t_mst_games` VALUES (1,'FootBall','The space here is for 5 vs 5'),(2,'VolleyBall','This is in indoor special court');

CREATE TABLE `t_mst_cuisine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `t_mst_cuisine` VALUES (1,'Dosai','This is a light weight breakfast item'),(2,'Idli','This is abreakfast item an ideal one for busy work');

CREATE TABLE `t_mst_amount` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `t_mst_amount` VALUES (1,'Dosai',20),(2,'Idli',15),(3,'FootBall',200),(4,'VolleyBall',200);

CREATE TABLE `t_dtl_slot` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `slotId` int(11) DEFAULT NULL,
  `gameName` varchar(20) DEFAULT NULL,
  `userName` varchar(50) DEFAULT NULL,
  `slotdate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `t_dtl_cuisine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cuisineId` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `amount` double DEFAULT NULL,
  `paystatus` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
