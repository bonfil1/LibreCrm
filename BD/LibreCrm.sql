CREATE DATABASE librecrm;

USE librecrm;

CREATE TABLE IF NOT EXISTS users(
id					int(36)		not null	auto_increment,
user_name			varchar(36)	not null,
password			varchar(36)	not null,
name				varchar(60)	not null,
last_name			varchar(60)	not null,
report_to			char(36)	null,
is_admin			tinyint(1)	null,
description			text		null,
date_entered		datetime	null,
date_modified		datetime	null,
modified_user_id 	char(36)	null,
created_by			char(36)	null,
last_login			datetime	null,
category_id			char(36)	null,
phone_home			varchar(50)	null,
phone_mobile		varchar(50)	null,
phone_work			varchar(50)	null,
phone_other			varchar(50)	null,
phone_fax			varchar(50)	null,
adress_street			varchar(50)	null,
adress_city_id			char(36)	null,
adress_state_id			char(36)	null,
adress_country_id		char(36)	null,
email_id			char(36)	null,
PRIMARY KEY(id));


CREATE TABLE IF NOT EXISTS  accounts(
id				int(36)		not null	auto_increment,
name				varchar(100)	not null,
rfc				varchar(100)	null,
date_entered			datetime	null,
date_modified			datetime	null,
modified_user_id		char(36)	null,
created_by			char(36)	null,
description			text		null,
asigned_user_id			char(36)	null,
account_type			varchar(50)	null,
industry			varchar(50)	null,
phone				varchar(50)	null,
phone_fax			varchar(50)	null,
billing_address_street		varchar(50)	null, 
billing_address_city		varchar(50)	null,
billing_address_state		varchar(50)	null,
billing_address_postalcode	varchar(50)	null,
billing_address_country		varchar(50)	null,
website				varchar(200)	null,
shipping_address_street		varchar(50)	null, 
shipping_address_city		varchar(50)	null,
shipping_address_state		varchar(50)	null,
shipping_address_postalcode	varchar(50)	null,
shipping_address_country	varchar(50)	null,
status				varchar(20)	null,

PRIMARY KEY(id));


CREATE TABLE IF NOT EXISTS  accounts_contacts(
id				int(36)		not null	auto_increment,
contact_id			varchar(36)	null,
account_id			varchar(36)	null,
date_modified			datetime	null,

PRIMARY KEY(id));


CREATE TABLE IF NOT EXISTS  accounts_opportunities(
id				int(36)		not null	auto_increment,
opportunitie_id			varchar(36)	null,
account_id			varchar(36)	null,
date_modified			datetime	null,

PRIMARY KEY(id));


CREATE TABLE IF NOT EXISTS  contacts(
id				int(36)		not null	auto_increment,
date_entered			datetime	null,
date_modified			datetime	null,
modified_user_id		char(36)	null,
created_by			char(36)	null,
description			text		null,
asigned_user_id			char(36)	null,
salutation			varchar(5)	null,
first_name			varchar(100)	null,
last_name			varchar(100)	null,
title				varchar(100)	null,
department			varchar(255)	null,
phone_home			varchar(50)	null,
phone_mobile			varchar(50)	null,
phone_work			varchar(50)	null,
phone_other			varchar(50)	null,
phone_fax			varchar(50)	null,
primary_address_street		varchar(50)	null, 
primary_address_city		varchar(50)	null,
primary_address_state		varchar(50)	null,
primary_address_postalcode	varchar(50)	null,
primary_address_country		varchar(50)	null,
assistant			varchar(255)	null,
assistant_phone			varchar(75)	null,
status				varchar(20)	null,
PRIMARY KEY(id));


CREATE TABLE IF NOT EXISTS opportunities(
id				int(36)		not null	auto_increment,
contact_id			char(36)	null,
opportunity			varchar(80)	not null,
date_entered			datetime	null,
date_modified			datetime	null,
modified_user_id		char(36)	null,
created_by			char(36)	null,
description			text		null,
asigned_user_id			char(36)	null,
opportunity_type		varchar(255)	null,
campaign_id			char(36)	null,
lead_source			varchar(50)	null,
amount				double		null,
amount_usdollar			double		null,
currency_id			char(36)	null,
date_closed			date		null,
next_step			varchar(100)	null,
sales_stage			varchar(255)	null,
probability			double		null,

PRIMARY KEY(id));


CREATE TABLE IF NOT EXISTS emails(
id				int(36)		not null	auto_increment,
date_entered			datetime	null,
date_modified			datetime	null,
assigned_user_id		char(36)	null,
modified_user_id		char(36)	null,
created_by			char(36)	null,
date_sent			datetime	null,
message_id			varchar(255)	null,
name				varchar(255)	null,
type				varchar(255)	null,
status				varchar(255)	null,
intent				varchar(255)	null,
parent_type			varchar(255)	null,			

PRIMARY KEY(id));


CREATE TABLE IF NOT EXISTS emails_email_addr_rel(
id				int(36)		not null	auto_increment,
email_id			char(36)	null,
address_type			varchar(4)	null,
email_address_id		char(36)	null,

PRIMARY KEY(id));


CREATE TABLE IF NOT EXISTS emails_text(
email_id			int(36)	        null,

from_addr			varchar(255)	null,
reply_to_addr			varchar(255)	null,
to_addrs			text		null,
cc_addrs			text		null,
bcc_addrs			text		null,
description			longtext	null,
description_html		longtext	null,
PRIMARY KEY(email_id));


CREATE TABLE IF NOT EXISTS emails_templates(
id				int(36)		not null	auto_increment,
date_entered			datetime	null,
date_modified			datetime	null,
modified_user_id		char(36)	null,
created_by			char(36)	null,
published			varchar(3)	null,
name				varchar(255)	null,
description			text		null,
subject				varchar(255)	null,
body				text		null,
body_html			text		null,
text_only			tinyint(1)	null,
PRIMARY KEY(id));


CREATE TABLE IF NOT EXISTS emails_addresses(
id				int(36)		not null	auto_increment,
email_address			varchar(255)	null,
email_address_caps		varchar(255)	null,
invalid_email			tinyint(1)	null,
opt_out				tinyint(1)	null,
date_created			datetime	null,
date_modified			datetime	null,
PRIMARY KEY(id));


CREATE TABLE IF NOT EXISTS campaigns(
id				int(36)		not null	auto_increment,
name				varchar(255)	null,
date_entered			datetime	null,
date_modified			datetime	null,
modified_user_id		char(36)	null,
created_by			char(36)	null,
asigned_user_id			char(36)	null,
refer_url			varchar(255)	null,
start_date			date		null,
end_date			date		null,
status				varchar(100)	null,
impressions			int(11)		null,
currency_id			int(36)		null,
budget				double		null,
expected_cost			double		null,
actual_cost			double		null,
expecting_revenue		double		null,
campaign_type			varchar(25)	null,
objective			text		null,
content				text		null,
product				varchar(60)	null,

PRIMARY KEY(id));


CREATE TABLE IF NOT EXISTS currency(
id				int(36)		not null	auto_increment,
name				varchar(36)	null,
symbol				varchar(36)	null,
iso4217				varchar(36)	null,
conversion_rate			double		null,
status				varchar(255)	null,
date_entered			datetime	null,
date_modified			datetime	null,
created_by			char(36)	null,
PRIMARY KEY(id));


CREATE TABLE IF NOT EXISTS rad(
id				int(36)		not null	auto_increment,
date_created			datetime	null,
date_modified			datetime	null,
date_reported			datetime	null,
created_by			char(36)	null,
modified_user_id		char(36)	null,
description			text		null,
document_name			varchar(255)	null,
cost_center			varchar(255)	null,
status				varchar(50)	null,
PRIMARY KEY(id));

CREATE TABLE IF NOT EXISTS rad_horas(
id_rad				int(36)		not null,
hour_begin			datetime	null,
hour_end			datetime	null,
activity			varchar(250)	null,
desciption			text		null,
id_account			char(36)	null,
id_contacts			char(36)	null,
PRIMARY KEY(id_rad));


CREATE TABLE IF NOT EXISTS pvd(
id				int(36)		not null	auto_increment,
date_created			datetime	null,
date_modified			datetime	null,
date_reported			datetime	null,
created_by			char(36)	null,
modified_user_id		char(36)	null,
description			text		null,
document_name			varchar(255)	null,
cost_center			varchar(255)	null,
status				varchar(50)	null,
PRIMARY KEY(id));

CREATE TABLE IF NOT EXISTS pvd_horas(
id_pvd				int(36)		not null,
hour_begin			datetime	null,
hour_end			datetime	null,
activity			varchar(250)	null,
desciption			text		null,
id_account			char(36)	null,
id_contacts			char(36)	null,
PRIMARY KEY(id_pvd));


CREATE TABLE IF NOT EXISTS menu_categorys(
id				int(36)		not null	auto_increment,
category			varchar(100)	null,
is_admin			tinyint(1)	null,
description			text		null,
date_created			datetime	null,
date_modified			datetime	null,
created_by			char(36)	null,
modified_by			char(36)	null,				
PRIMARY KEY(id));

