package com.bin.springboot.component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD}) // 注解类型， 级别
@Retention(RetentionPolicy.RUNTIME) // 运行时注解
public @interface Log {

	public enum ProcedureEnum { INVENTORY_STOCK,//分配库存
							    CREATE_BATCH,//创建批次
							    PICK,//捡货
						        JOIN_TRANS,//集包转运
						        SINGLE_TRANS,//单件转运
						        FENJIAN_TRANS,//分拣转运
						        DB_TRANS,//调拨转运
						        BJ_TRANS,//补货转运
						        OUTPUT_TWICE_PICK,//二次分拣
						        OUTPUT_MULTI_PKG,//多件包装/复核
						        OUTPUT_SINGLE_PKG,//单件包装
						        OUTPUT_DB_PKG,//调拨包装
						        OUTPUT_DB_COMMIT,//调拨确认
						        OUTPUT_PACKAGEPICK,//包裹分拣
						        OUTPUT_WEIGH,//待称重
						        OUTPUT_TAKEOVER,//已出库 
						        OUTPUT_SEEDOUTED //已发货
						        };
    ProcedureEnum procedure() ;
}
