--
-- Table structure for table `users`
--
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) NOT NULL,
  `email` varchar(100) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(60) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `enabled` bit(1) NOT NULL DEFAULT 1,
  `last_login` DATETIME(6) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


--
-- Table structure for table `roles`
--
CREATE TABLE IF NOT EXISTS `roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) NOT NULL,
  `name` varchar(30) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `enabled` bit(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ofx66keruapi6vyqpv6f2or37` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


--
-- Table structure for table `sectors`
--
CREATE TABLE `sectors` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`created_at` DATETIME(6) NOT NULL,
	`enabled` BIT(1) NOT NULL,
	`updated_at` DATETIME(6) NOT NULL,
	`name` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


--
-- Table structure for table `users_roles`
--
CREATE TABLE IF NOT EXISTS `users_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  UNIQUE KEY `UKq3r1u8cne2rw2hkr899xuh7vj` (`user_id`,`role_id`),
  KEY `FKj6m8fwv7oqv74fcehir1a9ffy` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


--
-- Table structure for table `clients`
--
CREATE TABLE `clients` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`created_at` DATETIME(6) NOT NULL,
	`enabled` BIT(1) NOT NULL,
	`updated_at` DATETIME(6) NOT NULL,
	`address` VARCHAR(255) NOT NULL,
	`city` VARCHAR(255) NOT NULL,
	`email` VARCHAR(255) NOT NULL,
	`name` VARCHAR(255) NOT NULL,
	`nit` VARCHAR(255) NOT NULL,
	`sector_id` BIGINT(20) NOT NULL,
	`user_id` BIGINT(20) NOT NULL,
	PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


--
-- Table structure for table `clients_contacts`
--
CREATE TABLE `clients_contacts` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`created_at` DATETIME(6) NOT NULL,
	`enabled` BIT(1) NOT NULL,
	`updated_at` DATETIME(6) NOT NULL,
	`email` VARCHAR(255) NOT NULL,
	`name` VARCHAR(255) NOT NULL,
	`client_id` BIGINT(20) NOT NULL,
	PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


--
-- Constraints for table `users_roles`
--
ALTER TABLE `users_roles`
  ADD CONSTRAINT `FK2o0jvgh89lemvvo17cbqvdxaa` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKj6m8fwv7oqv74fcehir1a9ffy` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);


--
-- Constraints for table `users_roles`
--
ALTER TABLE `clients`
  ADD CONSTRAINT `FKm413eey80457klbk330bwo5i8` FOREIGN KEY (`sector_id`) REFERENCES `sectors` (`id`),
  ADD CONSTRAINT `FKtiuqdledq2lybrds2k3rfqrv4` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);


--
-- Constraints for table `clients_contacts`
--
ALTER TABLE `clients_contacts`
  ADD CONSTRAINT `FK6ajqixsfkj7j7eqwrdgcdb3n` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`);