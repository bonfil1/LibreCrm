SELECT
u.user_name	AS nick,
u.password      AS pass,
u.is_admin	AS isadmin,
u.name		AS nombre,
u.last_name	AS apellidos,
u.last_login	AS fecha
FROM users AS u
WHERE u.user_name = 'bonfil1'
AND u.password = 'master12';