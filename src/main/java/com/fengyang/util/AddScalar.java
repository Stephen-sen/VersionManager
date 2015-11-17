package com.fengyang.util;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.type.BooleanType;
import org.hibernate.type.CharacterType;
import org.hibernate.type.DoubleType;
import org.hibernate.type.FloatType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.ShortType;
import org.hibernate.type.StringType;
import org.hibernate.type.TimestampType;

public class AddScalar {
    public AddScalar() {
    }

    public static <T> void addSclar(SQLQuery sqlQuery, Class<T> clazz) {
        if(clazz == null) {
            throw new NullPointerException("[clazz] could not be null!");
        } else {
            Field[] fields = clazz.getDeclaredFields();
            Field[] var6 = fields;
            int var5 = fields.length;

            for(int var4 = 0; var4 < var5; ++var4) {
                Field field = var6[var4];
                if(field.getType() != Long.TYPE && field.getType() != Long.class) {
                    if(field.getType() != Integer.TYPE && field.getType() != Integer.class) {
                        if(field.getType() != Character.TYPE && field.getType() != Character.class) {
                            if(field.getType() != Short.TYPE && field.getType() != Short.class) {
                                if(field.getType() != Double.TYPE && field.getType() != Double.class) {
                                    if(field.getType() != Float.TYPE && field.getType() != Float.class) {
                                        if(field.getType() != Boolean.TYPE && field.getType() != Boolean.class) {
                                        	if(field.getType() == String.class) {
                                                sqlQuery.addScalar(field.getName(), StringType.INSTANCE);
                                            } else if(field.getType() == Date.class) {
                                                sqlQuery.addScalar(field.getName(), TimestampType.INSTANCE);
                                            }
                                        } else {
                                            sqlQuery.addScalar(field.getName(), BooleanType.INSTANCE);
                                        }
                                    } else {
                                        sqlQuery.addScalar(field.getName(), FloatType.INSTANCE);
                                    }
                                } else {
                                    sqlQuery.addScalar(field.getName(), DoubleType.INSTANCE);
                                }
                            } else {
                                sqlQuery.addScalar(field.getName(), ShortType.INSTANCE);
                            }
                        } else {
                            sqlQuery.addScalar(field.getName(), CharacterType.INSTANCE);
                        }
                    } else {
                        sqlQuery.addScalar(field.getName(), IntegerType.INSTANCE);
                    }
                } else {
                    sqlQuery.addScalar(field.getName(), LongType.INSTANCE);
                }
            }

        }
    }

    @SuppressWarnings("rawtypes")
	public static <T> void addSclar(SQLQuery sqlQuery, Class<T> clazz, List<String> fieldList) {
        if(clazz == null) {
            throw new NullPointerException("[clazz] could not be null!");
        } else {
            if(fieldList != null && fieldList.size() > 0) {
                Field[] fields = clazz.getDeclaredFields();
                Iterator var5 = fieldList.iterator();

                while(var5.hasNext()) {
                    String fieldName = (String)var5.next();
                    Field[] var9 = fields;
                    int var8 = fields.length;

                    for(int var7 = 0; var7 < var8; ++var7) {
                        Field field = var9[var7];
                        if(fieldName.equals(field.getName())) {
                            if(field.getType() != Long.TYPE && field.getType() != Long.class) {
                                if(field.getType() != Integer.TYPE && field.getType() != Integer.class) {
                                    if(field.getType() != Character.TYPE && field.getType() != Character.class) {
                                        if(field.getType() != Short.TYPE && field.getType() != Short.class) {
                                            if(field.getType() != Double.TYPE && field.getType() != Double.class) {
                                                if(field.getType() != Float.TYPE && field.getType() != Float.class) {
                                                    if(field.getType() != Boolean.TYPE && field.getType() != Boolean.class) {
                                                        if(field.getType() == String.class) {
                                                            sqlQuery.addScalar(field.getName(), StringType.INSTANCE);
                                                        } else if(field.getType() == Date.class) {
                                                            sqlQuery.addScalar(field.getName(), TimestampType.INSTANCE);
                                                        }
                                                    } else {
                                                        sqlQuery.addScalar(field.getName(), BooleanType.INSTANCE);
                                                    }
                                                } else {
                                                    sqlQuery.addScalar(field.getName(), FloatType.INSTANCE);
                                                }
                                            } else {
                                                sqlQuery.addScalar(field.getName(), DoubleType.INSTANCE);
                                            }
                                        } else {
                                            sqlQuery.addScalar(field.getName(), ShortType.INSTANCE);
                                        }
                                    } else {
                                        sqlQuery.addScalar(field.getName(), CharacterType.INSTANCE);
                                    }
                                } else {
                                    sqlQuery.addScalar(field.getName(), IntegerType.INSTANCE);
                                }
                            } else {
                                sqlQuery.addScalar(field.getName(), LongType.INSTANCE);
                            }
                        }
                    }
                }
            }

        }
    }
}
