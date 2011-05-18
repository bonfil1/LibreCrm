CREATE DATABASE librecrm;

USE librecrm;


CREATE TABLE IF NOT EXISTS  departamentos(
id		int(36)		not null	auto_increment,
name		varchar(50)	null,
charge		varchar(50)	null,
description	text		null,
PRIMARY KEY(id));


CREATE TABLE IF NOT EXISTS  countries(
id		int(36)		not null	auto_increment,
name		varchar(100)	null,
PRIMARY KEY(id));


CREATE TABLE IF NOT EXISTS  states(
id		int(36)		not null	auto_increment,
country_id	char(36)	null,
name		varchar(100)	null,
PRIMARY KEY(id));

CREATE TABLE IF NOT EXISTS  cities(
id		int(36)		not null	auto_increment,
state_id	char(36)	null,
name		varchar(100)	null,
PRIMARY KEY(id));

CREATE TABLE IF NOT EXISTS  accounts(
id				int(36)		not null	auto_increment,
name				varchar(100)	not null,
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
shipping_address_country		varchar(50)	null,

PRIMARY KEY(id));


CREATE TABLE IF NOT EXISTS  accounts_contacts(
id		int(36)		not null	auto_increment,
contact_id	varchar(36)	null,
account_id	varchar(36)	null,
date_modified	datetime	null,

PRIMARY KEY(id));


CREATE TABLE IF NOT EXISTS  contacts_opportunities(
id		int(36)		not null	auto_increment,
opportunitie_id	varchar(36)	null,
account_id	varchar(36)	null,
date_modified	datetime	null,

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
PRIMARY KEY(id));


CREATE TABLE IF NOT EXISTS opportunities(
id				int(36)		not null	auto_increment,
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
email_id			char(36)	not null,

from_addr			varchar(255)	null,
reply_to_addr			varchar(255)	null,
to_addrs			text		null,
cc_addrs			text		null,
bcc_addrs			text		null,
description			longtext	null,
description_html		longtext	null,
PRIMARY KEY(id));


CREATE TABLE IF NOT EXISTS emails_templates(
id				char(36)	not null,
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





