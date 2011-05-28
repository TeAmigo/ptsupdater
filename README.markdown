## Readme for ptsupdater ##

ptsupdater uses the Interactive Brokers tws-api to update symbol quote 
information in the postgresql quotes1min database.

### How to call ###

Call with either 0 or 1 args, 0 updates all in db, 1 is a file for symbols to be updated.

#### Example input file format (base-symbol, expiry, exchange, begin-datetime, end-datetime): ####

    ZB, 20110621, ECBOT, 2011-02-28 00:00, 2011-04-30 16:00
    ZF, 20110630, ECBOT, 2011-02-28 00:00, 2011-04-30 16:00
    ZN, 20110621, ECBOT, 2011-02-28 00:00, 2011-04-30 16:00

