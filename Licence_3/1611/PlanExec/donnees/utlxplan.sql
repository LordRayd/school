DROP TABLE PLAN_TABLE purge ;
rem
rem $Header: utlxplan.sql big_dev/0 11-aug-95.14:02:45 achaudhr Exp $ xplainpl.sql
rem
Rem Copyright (c) 1988, 1995, 1996, 1998 by Oracle Corporation
Rem NAME
REM    UTLXPLAN.SQL
Rem  FUNCTION
Rem  NOTES
Rem  MODIFIED
Rem     mzait      02/19/98 -  add distribution method column
Rem     ddas       05/17/96 -  change search_columns to number
Rem     achaudhr   07/23/95 -  PTI: Add columns partition_{start, stop, id}
Rem     glumpkin   08/25/94 -  new optimizer fields
Rem     jcohen     11/05/93 -  merge changes from branch 1.1.710.1 - 9/24
Rem     jcohen     09/24/93 - #163783 add optimizer column
Rem     glumpkin   10/25/92 -  Renamed from XPLAINPL.SQL
Rem     jcohen     05/22/92 - #79645 - set node width to 128 (M_XDBI in gendef)
Rem     rlim       04/29/91 -         change char to varchar2
Rem   Peeler     10/19/88 - Creation
Rem
Rem This is the format for the table that is used by the EXPLAIN PLAN
Rem statement.  The explain statement requires the presence of this
Rem table in order to store the descriptions of the row sources.
create table PLAN_TABLE (
        statement_id    varchar2(30),
        timestamp       date,
        remarks         varchar2(80),
        operation       varchar2(30),
        options         varchar2(30),
        object_node     varchar2(128),
        object_owner    varchar2(30),
        object_name     varchar2(30),
        object_instance numeric,
        object_type     varchar2(30),
        optimizer       varchar2(255),
        search_columns  number,
        id              numeric,
        parent_id       numeric,
        position        numeric,
        cost            numeric,
        cardinality     numeric,
        bytes           numeric,
        other_tag       varchar2(255),
        partition_start varchar2(255),
        partition_stop  varchar2(255),
        partition_id    numeric,
        other           long,
        distribution    varchar2(30));

