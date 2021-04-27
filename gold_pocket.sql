/*
 Navicat Premium Data Transfer

 Source Server         : mandiri-academy
 Source Server Type    : PostgreSQL
 Source Server Version : 130002
 Source Host           : localhost:5432
 Source Catalog        : gold_pocket_db
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 130002
 File Encoding         : 65001

 Date: 27/04/2021 22:28:33
*/


-- ----------------------------
-- Sequence structure for customer_customer_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."customer_customer_id_seq";
CREATE SEQUENCE "public"."customer_customer_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."customer_customer_id_seq" OWNER TO "postgres";

-- ----------------------------
-- Sequence structure for product_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."product_id_seq";
CREATE SEQUENCE "public"."product_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."product_id_seq" OWNER TO "postgres";

-- ----------------------------
-- Table structure for m_customers
-- ----------------------------
DROP TABLE IF EXISTS "public"."m_customers";
CREATE TABLE "public"."m_customers" (
  "id" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "first_name" varchar(30) COLLATE "pg_catalog"."default",
  "last_name" varchar(30) COLLATE "pg_catalog"."default",
  "birth_date" date,
  "address" text COLLATE "pg_catalog"."default",
  "status" int4,
  "username" varchar(30) COLLATE "pg_catalog"."default",
  "password" varchar(100) COLLATE "pg_catalog"."default",
  "email" varchar(100) COLLATE "pg_catalog"."default",
  "created_at" date,
  "updated_at" date
)
;
ALTER TABLE "public"."m_customers" OWNER TO "postgres";

-- ----------------------------
-- Records of m_customers
-- ----------------------------
BEGIN;
INSERT INTO "public"."m_customers" VALUES ('8a68e47278f8d7b30178f8d7c4950000', 'updateeee', 'siaa', '2020-02-02', 'jalan', 1, 'updtdirga', 'abcd', '@gmail', NULL, NULL);
INSERT INTO "public"."m_customers" VALUES ('8a68e47278f8d7b30178f8d865960001', 'dirgantara', 'siahaan', '2020-02-02', 'jalan', 1, 'dirga', 'password', '@gmail', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for m_history_prices
-- ----------------------------
DROP TABLE IF EXISTS "public"."m_history_prices";
CREATE TABLE "public"."m_history_prices" (
  "id" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "history_date" timestamp(6),
  "price_buy" numeric,
  "price_sell" numeric,
  "product_id" varchar(100) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "public"."m_history_prices" OWNER TO "postgres";

-- ----------------------------
-- Records of m_history_prices
-- ----------------------------
BEGIN;
INSERT INTO "public"."m_history_prices" VALUES ('4028e49078f9f3060178f9f46b8d0000', NULL, 100, 200, '4028e49078f9e3050178f9e34e5e0000');
INSERT INTO "public"."m_history_prices" VALUES ('4028e49078f9ff1d0178f9ffa59c0000', '2021-04-22 21:33:04.127', 1100, 1200, '4028e49078f9e3050178f9e34e5e0000');
INSERT INTO "public"."m_history_prices" VALUES ('4028e49078fa03bf0178fa0415110000', '2021-04-22 21:37:54.809', 1100, 1200, '4028e49078f9e3050178f9e34e5e0000');
INSERT INTO "public"."m_history_prices" VALUES ('4028e49078fa08cb0178fa08d7880000', '2021-04-22 21:43:06.733', 1100, 1200, '4028e49078f9e3050178f9e34e5e0000');
INSERT INTO "public"."m_history_prices" VALUES ('8a68e47278fce6460178fce6e8e50000', NULL, 100, 20, NULL);
INSERT INTO "public"."m_history_prices" VALUES ('8a68e47278fcf5d80178fcf605c00001', '2021-04-23 11:21:24.981', 100, 20, '8a68e47278fcf5d80178fcf605900000');
INSERT INTO "public"."m_history_prices" VALUES ('8a68e47278fcf77c0178fcf7c1460001', '2021-04-23 11:23:18.535', 100, 20, '8a68e47278fcf77c0178fcf7c1180000');
INSERT INTO "public"."m_history_prices" VALUES ('8a68e47278fd6d580178fd6db75a0001', '2021-04-23 13:32:09.245', 100, 20, '8a68e47278fd6d580178fd6db72f0000');
INSERT INTO "public"."m_history_prices" VALUES ('8a68e47278fdeeed0178fdf089ca0001', '2021-04-23 15:55:02.826', 300, 350, '8a68e47278fdeeed0178fdf089b10000');
INSERT INTO "public"."m_history_prices" VALUES ('8a68e47278fdeeed0178fdf13ef10003', '2021-04-23 15:55:49.23', 300, 350, '8a68e47278fdeeed0178fdf13eef0002');
INSERT INTO "public"."m_history_prices" VALUES ('4028e4907912fcd60179130c4d71000a', '2021-04-27 18:17:23.944', 100, 20, '4028e4907912fcd60179130c4d6c0009');
COMMIT;

-- ----------------------------
-- Table structure for m_pockets
-- ----------------------------
DROP TABLE IF EXISTS "public"."m_pockets";
CREATE TABLE "public"."m_pockets" (
  "id" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "pocket_name" varchar(255) COLLATE "pg_catalog"."default",
  "pocket_qty" float4,
  "customer_id" varchar(100) COLLATE "pg_catalog"."default",
  "product_id" varchar(100) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "public"."m_pockets" OWNER TO "postgres";

-- ----------------------------
-- Records of m_pockets
-- ----------------------------
BEGIN;
INSERT INTO "public"."m_pockets" VALUES ('8a68e47278f8f16a0178f8f7718d0001', 'tabungan hari tua', 23, '8a68e47278f8d7b30178f8d865960001', 'c001');
INSERT INTO "public"."m_pockets" VALUES ('4028e4907912fcd601791307ba250006', 'gold', 0, '8a68e47278f8d7b30178f8d865960001', '8a68e47278fdeeed0178fdf13eef0002');
INSERT INTO "public"."m_pockets" VALUES ('4028e4907912fcd601791307c9840007', 'silver', 0, '8a68e47278f8d7b30178f8d865960001', '8a68e47278fdeeed0178fdf13eef0002');
INSERT INTO "public"."m_pockets" VALUES ('4028e4907912fcd601791307d9910008', 'platinum', 0, '8a68e47278f8d7b30178f8d865960001', '8a68e47278fdeeed0178fdf13eef0002');
INSERT INTO "public"."m_pockets" VALUES ('4028e4907912fcd6017912ff68440001', 'tabungan hari tua', 6, '8a68e47278f8d7b30178f8d865960001', '8a68e47278fdeeed0178fdf13eef0002');
COMMIT;

-- ----------------------------
-- Table structure for m_products
-- ----------------------------
DROP TABLE IF EXISTS "public"."m_products";
CREATE TABLE "public"."m_products" (
  "id" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "product_name" varchar(100) COLLATE "pg_catalog"."default",
  "product_price_buy" numeric,
  "product_price_sell" numeric,
  "product_image" varchar(100) COLLATE "pg_catalog"."default",
  "product_status" int4,
  "created_at" date,
  "updated_at" date
)
;
ALTER TABLE "public"."m_products" OWNER TO "postgres";

-- ----------------------------
-- Records of m_products
-- ----------------------------
BEGIN;
INSERT INTO "public"."m_products" VALUES ('c001', 'tabanas', 100, 200, 'image', 1, '2021-04-22', '2021-04-22');
INSERT INTO "public"."m_products" VALUES ('4028e49078f9d1ea0178f9d201240000', 'pempresasdsadasd', 100, 150, 'testtest', 1, NULL, '2021-04-22');
INSERT INTO "public"."m_products" VALUES ('4028e49078f9d1ea0178f9d2bf040001', 'pempres', 100, 150, 'dirga', 1, '2021-04-22', NULL);
INSERT INTO "public"."m_products" VALUES ('4028e49078f9e3050178f9e34e5e0000', 'pempresasdsadasd', 100, 150, 'testtest', 1, '2021-04-22', '2021-04-22');
INSERT INTO "public"."m_products" VALUES ('8a68e47278fcab0d0178fcacb12a0000', NULL, 300, 350, 'dirr', 1, '2021-04-21', '2021-04-21');
INSERT INTO "public"."m_products" VALUES ('8a68e47278fcddf90178fcde08f60000', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."m_products" VALUES ('8a68e47278fce6460178fce6e9180001', NULL, 100, 20, 'asdsad', 1, NULL, NULL);
INSERT INTO "public"."m_products" VALUES ('8a68e47278fcf5d80178fcf605900000', NULL, 100, 20, 'hahahhaaahahah', 1, '2021-04-23', '2021-04-23');
INSERT INTO "public"."m_products" VALUES ('8a68e47278fcf77c0178fcf7c1180000', 'asdas', 100, 20, 'hahahhaaahahah', NULL, '2021-04-23', '2021-04-23');
INSERT INTO "public"."m_products" VALUES ('8a68e47278fd6d580178fd6db72f0000', 'asdas', 100, 20, 'masuk dluu', NULL, '2021-04-23', '2021-04-23');
INSERT INTO "public"."m_products" VALUES ('8a68e47278fdeeed0178fdf089b10000', NULL, 300, 350, 'baru baru', 1, '2021-04-23', '2021-04-23');
INSERT INTO "public"."m_products" VALUES ('8a68e47278fdeeed0178fdf13eef0002', 'Tabungan Pensiun', 300, 350, 'baru baru', 1, '2021-04-23', '2021-04-23');
INSERT INTO "public"."m_products" VALUES ('4028e4907912fcd60179130c4d6c0009', 'asdas', 100, 20, 'masuk dluu', 1, '2021-04-27', '2021-04-27');
COMMIT;

-- ----------------------------
-- Table structure for t_purchase_details
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_purchase_details";
CREATE TABLE "public"."t_purchase_details" (
  "purchase_detail_id" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "price" numeric,
  "quantity_in_gram" float4,
  "product_id" varchar(100) COLLATE "pg_catalog"."default",
  "purchase_id" varchar(100) COLLATE "pg_catalog"."default",
  "pocket_id" varchar(255) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "public"."t_purchase_details" OWNER TO "postgres";

-- ----------------------------
-- Records of t_purchase_details
-- ----------------------------
BEGIN;
INSERT INTO "public"."t_purchase_details" VALUES ('4028e4907912f994017912f9dfb20001', 200, 1, 'c001', '4028e4907912f994017912f9dfad0000', '8a68e47278f8f16a0178f8f7718d0001');
INSERT INTO "public"."t_purchase_details" VALUES ('4028e4907912f994017912f9dfb20002', 200, 2, 'c001', '4028e4907912f994017912f9dfad0000', '8a68e47278f8f16a0178f8f7718d0001');
INSERT INTO "public"."t_purchase_details" VALUES ('4028e4907912f994017912fa84d80004', 200, 1, 'c001', '4028e4907912f994017912fa84d70003', '8a68e47278f8f16a0178f8f7718d0001');
INSERT INTO "public"."t_purchase_details" VALUES ('4028e4907912f994017912fa84d80005', 200, 2, 'c001', '4028e4907912f994017912fa84d70003', '8a68e47278f8f16a0178f8f7718d0001');
INSERT INTO "public"."t_purchase_details" VALUES ('4028e4907912fcd601791300e81e0003', 350, 2, '8a68e47278fdeeed0178fdf13eef0002', '4028e4907912fcd601791300e81b0002', '4028e4907912fcd6017912ff68440001');
INSERT INTO "public"."t_purchase_details" VALUES ('4028e4907912fcd6017913011aa50005', 350, 2, '8a68e47278fdeeed0178fdf13eef0002', '4028e4907912fcd6017913011aa50004', '4028e4907912fcd6017912ff68440001');
INSERT INTO "public"."t_purchase_details" VALUES ('4028e49079132baf0179132cbe450001', 350, 2, '8a68e47278fdeeed0178fdf13eef0002', '4028e49079132baf0179132cbe3e0000', '4028e4907912fcd6017912ff68440001');
INSERT INTO "public"."t_purchase_details" VALUES ('4028e49079132baf0179132d123c0003', 350, 2, '8a68e47278fdeeed0178fdf13eef0002', '4028e49079132baf0179132d123c0002', '4028e4907912fcd6017912ff68440001');
INSERT INTO "public"."t_purchase_details" VALUES ('4028e49079132e800179132e928e0001', 350, 2, '8a68e47278fdeeed0178fdf13eef0002', '4028e49079132e800179132e92890000', '4028e4907912fcd6017912ff68440001');
INSERT INTO "public"."t_purchase_details" VALUES ('4028e49079132e800179132eac6b0003', 350, 2, '8a68e47278fdeeed0178fdf13eef0002', '4028e49079132e800179132eac6a0002', '4028e4907912fcd6017912ff68440001');
INSERT INTO "public"."t_purchase_details" VALUES ('4028e49079132f8b0179132fb1fc0001', 350, 2, '8a68e47278fdeeed0178fdf13eef0002', '4028e49079132f8b0179132fb1f60000', '4028e4907912fcd6017912ff68440001');
INSERT INTO "public"."t_purchase_details" VALUES ('4028e49079132f8b01791330129c0003', 350, 2, '8a68e47278fdeeed0178fdf13eef0002', '4028e49079132f8b01791330129c0002', '4028e4907912fcd6017912ff68440001');
INSERT INTO "public"."t_purchase_details" VALUES ('4028e49079132f8b017913304ec50005', 350, 2, '8a68e47278fdeeed0178fdf13eef0002', '4028e49079132f8b017913304ec40004', '4028e4907912fcd6017912ff68440001');
COMMIT;

-- ----------------------------
-- Table structure for t_purchases
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_purchases";
CREATE TABLE "public"."t_purchases" (
  "purchase_id" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "purchase_date" date,
  "customer_id" varchar(100) COLLATE "pg_catalog"."default",
  "purchase_type" int2
)
;
ALTER TABLE "public"."t_purchases" OWNER TO "postgres";

-- ----------------------------
-- Records of t_purchases
-- ----------------------------
BEGIN;
INSERT INTO "public"."t_purchases" VALUES ('4028e4907912f994017912f9dfad0000', '2021-04-27', '8a68e47278f8d7b30178f8d865960001', NULL);
INSERT INTO "public"."t_purchases" VALUES ('4028e4907912f994017912fa84d70003', '2021-04-27', '8a68e47278f8d7b30178f8d865960001', NULL);
INSERT INTO "public"."t_purchases" VALUES ('4028e4907912fcd601791300e81b0002', '2021-04-27', '8a68e47278f8d7b30178f8d865960001', NULL);
INSERT INTO "public"."t_purchases" VALUES ('4028e4907912fcd6017913011aa50004', '2021-04-27', '8a68e47278f8d7b30178f8d865960001', NULL);
INSERT INTO "public"."t_purchases" VALUES ('4028e49079132baf0179132cbe3e0000', '2021-04-27', '8a68e47278f8d7b30178f8d865960001', 1);
INSERT INTO "public"."t_purchases" VALUES ('4028e49079132baf0179132d123c0002', '2021-04-27', '8a68e47278f8d7b30178f8d865960001', 0);
INSERT INTO "public"."t_purchases" VALUES ('4028e49079132e800179132e92890000', '2021-04-27', '8a68e47278f8d7b30178f8d865960001', 0);
INSERT INTO "public"."t_purchases" VALUES ('4028e49079132e800179132eac6a0002', '2021-04-27', '8a68e47278f8d7b30178f8d865960001', 0);
INSERT INTO "public"."t_purchases" VALUES ('4028e49079132f8b0179132fb1f60000', '2021-04-27', '8a68e47278f8d7b30178f8d865960001', 0);
INSERT INTO "public"."t_purchases" VALUES ('4028e49079132f8b01791330129c0002', '2021-04-27', '8a68e47278f8d7b30178f8d865960001', 1);
INSERT INTO "public"."t_purchases" VALUES ('4028e49079132f8b017913304ec40004', '2021-04-27', '8a68e47278f8d7b30178f8d865960001', 1);
COMMIT;

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."customer_customer_id_seq"
OWNED BY "public"."m_customers"."id";
SELECT setval('"public"."customer_customer_id_seq"', 8, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."product_id_seq"
OWNED BY "public"."m_products"."id";
SELECT setval('"public"."product_id_seq"', 6, true);

-- ----------------------------
-- Primary Key structure for table m_customers
-- ----------------------------
ALTER TABLE "public"."m_customers" ADD CONSTRAINT "m_customer_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table m_history_prices
-- ----------------------------
ALTER TABLE "public"."m_history_prices" ADD CONSTRAINT "history_price_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table m_pockets
-- ----------------------------
ALTER TABLE "public"."m_pockets" ADD CONSTRAINT "m_pocket_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table m_products
-- ----------------------------
ALTER TABLE "public"."m_products" ADD CONSTRAINT "product_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_purchase_details
-- ----------------------------
ALTER TABLE "public"."t_purchase_details" ADD CONSTRAINT "purchase_detail_pkey" PRIMARY KEY ("purchase_detail_id");

-- ----------------------------
-- Primary Key structure for table t_purchases
-- ----------------------------
ALTER TABLE "public"."t_purchases" ADD CONSTRAINT "purchase_pkey" PRIMARY KEY ("purchase_id");

-- ----------------------------
-- Foreign Keys structure for table m_history_prices
-- ----------------------------
ALTER TABLE "public"."m_history_prices" ADD CONSTRAINT "fk_product_history" FOREIGN KEY ("product_id") REFERENCES "public"."m_products" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table m_pockets
-- ----------------------------
ALTER TABLE "public"."m_pockets" ADD CONSTRAINT "fk_pocket_customer" FOREIGN KEY ("customer_id") REFERENCES "public"."m_customers" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."m_pockets" ADD CONSTRAINT "fk_pocket_product" FOREIGN KEY ("product_id") REFERENCES "public"."m_products" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table t_purchase_details
-- ----------------------------
ALTER TABLE "public"."t_purchase_details" ADD CONSTRAINT "fk_purchase_detail_product" FOREIGN KEY ("product_id") REFERENCES "public"."m_products" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."t_purchase_details" ADD CONSTRAINT "fk_purchase_detail_purchase" FOREIGN KEY ("purchase_id") REFERENCES "public"."t_purchases" ("purchase_id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table t_purchases
-- ----------------------------
ALTER TABLE "public"."t_purchases" ADD CONSTRAINT "fk_purchase_customer" FOREIGN KEY ("customer_id") REFERENCES "public"."m_customers" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
