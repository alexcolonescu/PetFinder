INSERT INTO role(role_id, name) VALUES (1, 'ROLE_ADMIN')
INSERT INTO role(role_id, name) VALUES (2, 'ROLE_USER')
--INSERT INTO role(role_id, name) VALUES (998, 'ROLE_ADMIN')
--
------password1
INSERT INTO user(user_id, enabled, email, full_name, username, password, account_non_expired, account_non_locked, credentials_non_expired, random_token) VALUES (999, 1, 'admin_email', 'admin_lastname', 'admin', '$2a$04$aAiATQxdXgbVhzF3Eujl1umIGVzZUTYN4m6phRLUQdu.M.1ZS/Sye', true, true, true, '$2a$04$aAiATQxdXgbVhzF3Eujl1umIGVzZUTYN4m6phRLUQdu.M.1ZS/Sye')
--INSERT INTO my_user(user_id, enabled, email, full_name, username, password, account_non_expired, account_non_locked, credentials_non_expired) VALUES (2, 1, 'user_email@email.ro', 'user_lastName', 'user_name', '$2a$04$6BqxSLynCIDsRQdXPbO65e7ifpTaLY.IAu.ZFYIOkF63ABCGxp6lW', true, true, true)
--
--
INSERT INTO USERS_ROLES(USER_ID, ROLE_ID) VALUES (999, 1)
--INSERT INTO USERS_ROLES(USER_ID, ROLE_ID) VALUES (1, 999)
--INSERT INTO USERS_ROLES(USER_ID, ROLE_ID) VALUES (2, 998)