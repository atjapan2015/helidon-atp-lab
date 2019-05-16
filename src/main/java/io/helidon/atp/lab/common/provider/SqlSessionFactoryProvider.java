package io.helidon.atp.lab.common.provider;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.cdi.SessionFactoryProvider;

import io.helidon.atp.lab.common.config.GlobalConfig;

@ApplicationScoped
public class SqlSessionFactoryProvider {

	@Produces
	@SessionFactoryProvider
	@ApplicationScoped
	public SqlSessionFactory produceFactory() {
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("product", transactionFactory, GlobalConfig.ds);
		Configuration configuration = new Configuration(environment);
		configuration.getTypeAliasRegistry().registerAliases("io.helidon.atp.lab.entity");
		configuration.addMappers("io.helidon.atp.lab.mapper");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(configuration);
		return factory;
	}
}
