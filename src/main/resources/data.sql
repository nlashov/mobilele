INSERT INTO users (id, email, first_name, last_name, image_url, is_active, password)
VALUES (1, 'chichoniki@gmail.com', 'Nikola', 'Lashov', null, 1, '506af577d658d1735f219974727b352216b4ec93d57efb06569085cd3c9d80c7eaf6ea9e252e1ac4');

INSERT INTO brands (id, name)
VALUES (1, 'Ford'),
       (2, 'Toyota');

INSERT INTO models (id, name, category, start_year, end_year, brand_id, image_url)
VALUES (1, 'Fiesta', 'CAR', 1976, null, 1, 'https://spct2000.files.wordpress.com/2016/12/fordfiesta_1976-1983_ford-social.jpg'),
       (2, 'Escort', 'CAR', 1968, null, 1, 'https://www.auto-data.net/images/f130/Ford-Escort-I-AFH-ATH.jpg'),
       (3, 'Yaris', 'CAR', 1999, null, 2, 'https://www.edmunds.com/assets/m/ford/escort/1999/oem/1999_ford_escort_sedan_se_fq_oem_1_500.jpg');
