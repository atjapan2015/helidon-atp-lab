package io.helidon.atp.lab.common.config;

import javax.inject.Singleton;
import javax.sql.DataSource;

@Singleton
public class GlobalConfig {

	public static DataSource ds = null;
}
