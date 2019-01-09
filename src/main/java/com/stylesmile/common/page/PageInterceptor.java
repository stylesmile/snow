//package com.Stylesmile.common.page;
//
//import java.lang.reflect.InvocationTargetException;
//import java.sql.Connection;
//import java.util.Properties;
//
//import org.apache.ibatis.executor.Executor;
//import org.apache.ibatis.executor.statement.StatementHandler;
//import org.apache.ibatis.mapping.BoundSql;
//import org.apache.ibatis.mapping.MappedStatement;
//import org.apache.ibatis.plugin.Interceptor;
//import org.apache.ibatis.plugin.Intercepts;
//import org.apache.ibatis.plugin.Invocation;
//import org.apache.ibatis.plugin.Plugin;
//import org.apache.ibatis.plugin.Signature;
//import org.apache.ibatis.reflection.MetaObject;
//import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
//import org.apache.ibatis.reflection.factory.ObjectFactory;
//import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
//import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
//import org.apache.ibatis.session.ResultHandler;
//import org.apache.ibatis.session.RowBounds;
//
//import cn.com.common.page.PageExecutor;
//
//
//@Intercepts({
//        @Signature(method = "query", type = Executor.class, args = {MappedStatement.class, Object.class,
//                RowBounds.class, ResultHandler.class}),
//        @Signature(method = "prepare", type = StatementHandler.class, args = {Connection.class})})
//public class PageInterceptor implements Interceptor {
//
//    private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
//    private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
//
//    private String pattern = "^.*page.*$";    // 需要进行分页操作的字符串正则表达式
//
//    /**
//     * 数据库方言：目前只支持mysql、oracle、sqlServer；默认mysql
//     */
//    private String dialect = "mysql";
//
//    public String getPattern() {
//        return pattern;
//    }
//
//    public void setPattern(String pattern) {
//        this.pattern = pattern;
//    }
//
//    public String getDialect() {
//        return dialect;
//    }
//
//    public void setDialect(String dialect) {
//        this.dialect = dialect;
//    }
//
//    @Override
//    public Object intercept(Invocation invocation) throws Throwable {
//        if (invocation.getTarget() instanceof StatementHandler) {
//            return handleStatementHandler(invocation);
//        }
//        return invocation.proceed();
//    }
//
//    /**
//     * @param invocation
//     * @return
//     * @throws IllegalAccessException
//     * @throws InvocationTargetException
//     */
//    private Object handleStatementHandler(Invocation invocation)
//            throws InvocationTargetException, IllegalAccessException {
//        StatementHandler statementHandler = (StatementHandler) invocation
//                .getTarget();
//        MetaObject metaStatementHandler = MetaObject.forObject(
//                statementHandler, DEFAULT_OBJECT_FACTORY,
//                DEFAULT_OBJECT_WRAPPER_FACTORY);
//        RowBounds rowBounds = (RowBounds) metaStatementHandler
//                .getValue("delegate.rowBounds");
//        if (rowBounds == null || (rowBounds.getOffset() == RowBounds.NO_ROW_OFFSET && rowBounds
//                .getLimit() == RowBounds.NO_ROW_LIMIT)) {
//            return invocation.proceed();
//        }
//
//        // 分离代理对象链(由于目标类可能被多个拦截器拦截，从而形成多次代理，通过下面的两次循环可以分离出最原始的的目标类)
//        while (metaStatementHandler.hasGetter("h")) {
//            Object object = metaStatementHandler.getValue("h");
//            metaStatementHandler = MetaObject.forObject(object,
//                    DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
//        }
//        // 分离最后一个代理对象的目标类
//        while (metaStatementHandler.hasGetter("target")) {
//            Object object = metaStatementHandler.getValue("target");
//            metaStatementHandler = MetaObject.forObject(object,
//                    DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
//        }
//
//        // 将mybatis的内存分页，调整为物理分页
//        BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
//        String sql = boundSql.getSql();
//        // 重写sql
//        String pageSql = PageSqlFactory.getPageSqlByDialect(this.dialect, sql, rowBounds);
//        metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
//        // 采用物理分页后，就不需要mybatis的内存分页了，所以重置下面的两个参数
//        metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
//        metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);
//
//        // 将执行权交给下一个拦截器
//        return invocation.proceed();
//    }
//
//    @Override
//    public Object plugin(Object o) {
//        if (Executor.class.isAssignableFrom(o.getClass())) {
//            PageExecutor executor = new PageExecutor((Executor) o, pattern);
//            return Plugin.wrap(executor, this);
//        } else if (o instanceof StatementHandler) {
//            return Plugin.wrap(o, this);
//        }
//        return o;
//    }
//
//    @Override
//    public void setProperties(Properties properties) {
//    }
//
//}