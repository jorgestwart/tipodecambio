insert into currency (id, description_currency, abbreviation_currency, symbol_currency, country_currency) 
values ('6394d372-c66a-474d-b35f-518f854ed505', 'SOL PERUANO', 'PEN', 'S/.', 'PERU');

insert into currency (id, description_currency, abbreviation_currency, symbol_currency, country_currency) 
values ('7c5aaedf-dffe-4b0c-9d67-7da6936d7fd0', 'DOLAR ESTADOUNIDENSE', 'USD', 'US$', 'ESTADOS UNIDOS');



insert into currency_pair (id, description_currency_pair, abbreviation_currency_pair, type_operation_currency_pair, currency_pair_ori_id, currency_pair_des_id)
values ('f5358b73-a534-4123-9e08-2385a087fc0a','Convertir soles peruanos a dolares estadounidenses','PEN/USD','/','6394d372-c66a-474d-b35f-518f854ed505','7c5aaedf-dffe-4b0c-9d67-7da6936d7fd0');

insert into currency_pair (id, description_currency_pair, abbreviation_currency_pair, type_operation_currency_pair, currency_pair_ori_id, currency_pair_des_id)
values ('ded21599-8dab-4617-beae-46291c3a3d38','Convertir dolares estadounidenses a soles peruanos','USD/PEN','*','7c5aaedf-dffe-4b0c-9d67-7da6936d7fd0','6394d372-c66a-474d-b35f-518f854ed505');



insert into exchange_rate (id, date_exchange_rate, amount_exchange_rate, currency_pair_idem)
values ('50abc919-5bc5-4db9-9ceb-298efe47d457', '2022-11-18', 3.827, 'f5358b73-a534-4123-9e08-2385a087fc0a');

insert into exchange_rate (id, date_exchange_rate, amount_exchange_rate, currency_pair_idem)
values ('73c404b6-5e71-4dd5-bfdb-181d650639cc', '2022-11-18', 3.827, 'ded21599-8dab-4617-beae-46291c3a3d38');

insert into exchange_rate (id, date_exchange_rate, amount_exchange_rate, currency_pair_idem)
values ('783739fd-b265-4f79-83b6-58e4b11e0f7d', '2022-11-19', 3.838, 'f5358b73-a534-4123-9e08-2385a087fc0a');

insert into exchange_rate (id, date_exchange_rate, amount_exchange_rate, currency_pair_idem)
values ('54810c90-8560-4110-b252-988568c6fdaf', '2022-11-19', 3.838, 'ded21599-8dab-4617-beae-46291c3a3d38');

insert into exchange_rate (id, date_exchange_rate, amount_exchange_rate, currency_pair_idem)
values ('9130375f-9bd2-4081-8425-a4c0bf59c64c', '2022-11-20', 3.882, 'f5358b73-a534-4123-9e08-2385a087fc0a');

insert into exchange_rate (id, date_exchange_rate, amount_exchange_rate, currency_pair_idem)
values ('6bde9021-3ce4-419e-83c0-15c8d4338c90', '2022-11-20', 3.882, 'ded21599-8dab-4617-beae-46291c3a3d38');

insert into exchange_rate (id, date_exchange_rate, amount_exchange_rate, currency_pair_idem)
values ('2ba57e9a-ea19-40cb-ae7e-6062c699ac46', '2022-11-21', 3.894, 'f5358b73-a534-4123-9e08-2385a087fc0a');

insert into exchange_rate (id, date_exchange_rate, amount_exchange_rate, currency_pair_idem)
values ('d7f6d4c3-ccc4-4e76-ba34-fe69b0225338', '2022-11-21', 3.894, 'ded21599-8dab-4617-beae-46291c3a3d38');

insert into exchange_rate (id, date_exchange_rate, amount_exchange_rate, currency_pair_idem)
values ('a946517f-0aa4-48e2-b81b-a1d4f5afc4b3', '2022-11-22', 3.895, 'f5358b73-a534-4123-9e08-2385a087fc0a');

insert into exchange_rate (id, date_exchange_rate, amount_exchange_rate, currency_pair_idem)
values ('928008e5-66d7-4491-afb7-d1c8ab5c467e', '2022-11-22', 3.895, 'ded21599-8dab-4617-beae-46291c3a3d38');

insert into exchange_rate (id, date_exchange_rate, amount_exchange_rate, currency_pair_idem)
values ('a3e94f05-cb5a-448f-8f4a-82e214d0456a', '2022-11-23', 3.899, 'f5358b73-a534-4123-9e08-2385a087fc0a');

insert into exchange_rate (id, date_exchange_rate, amount_exchange_rate, currency_pair_idem)
values ('532a4728-2065-4f46-9ab0-fe6cbc34267f', '2022-11-23', 3.899, 'ded21599-8dab-4617-beae-46291c3a3d38');



