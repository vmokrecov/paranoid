-- -------------------------------
-- Log table structure
-- -------------------------------
CREATE TABLE IF NOT EXISTS public.logbook
(
	id                                      BIGSERIAL          not null
		constraint logbook_pkey
			primary key,
    event_name                              varchar(255),
    method                                  varchar(255),
    path                                    varchar(255),
    headers                                 varchar(2000),
    param                                   varchar(2000),
	system                                  varchar(255),
    host                                    varchar(255),
    result                                  text,
	version                                 bigint,
    created_at                              timestamp          not null,
    updated_at                              timestamp          not null
);
COMMENT ON TABLE public.logbook IS 'Log table';
COMMENT ON COLUMN public.logbook.id IS 'Id';
COMMENT ON COLUMN public.logbook.event_name IS 'Event name';
COMMENT ON COLUMN public.logbook.method IS 'Operation method';
COMMENT ON COLUMN public.logbook.path IS 'Method path';
COMMENT ON COLUMN public.logbook.headers IS 'Headers';
COMMENT ON COLUMN public.logbook.param IS 'Params';
COMMENT ON COLUMN public.logbook.system IS 'Event source';
COMMENT ON COLUMN public.logbook.host IS 'Host information (IP address or host name)';
COMMENT ON COLUMN public.logbook.result IS 'Result';
COMMENT ON COLUMN public.logbook.version IS 'Version';
COMMENT ON COLUMN public.logbook.created_at IS 'Date/time when the entry was created';
COMMENT ON COLUMN public.logbook.updated_at IS 'Date/time when the entry was updated';
