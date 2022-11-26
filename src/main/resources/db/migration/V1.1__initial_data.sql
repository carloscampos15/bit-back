INSERT INTO `roles`
    (`id`, `name`, `created_at`, `updated_at`)
VALUES (1, 'ROLE_USER', now(), now());

INSERT INTO `roles`
    (`id`, `name`, `created_at`, `updated_at`)
VALUES (2, 'ROLE_ADMIN', now(), now());

INSERT INTO `users`
    (`id`, `email`, `name`, `lastname`, `password`, `enabled`, `last_login`, `created_at`, `updated_at`)
VALUES (1, 'carlos@gmail.com', 'carlos', 'campos', '$2a$10$1Gu2Gc1vSS1Y3KltlzCK4OxwPSeyZBgyvTGUYXWFGbAZq6Y14ia7e', 1, now(), now(), now());

INSERT INTO `users_roles`
    (`user_id`, `role_id`)
VALUES (1, 2);