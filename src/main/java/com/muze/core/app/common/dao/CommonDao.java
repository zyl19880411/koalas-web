package com.muze.core.app.common.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public interface CommonDao {

	//刚进入页面的时候 由二级菜单的parentID获取所有按钮的ID
	public List<Map<String,String>> getbtnPermission(@Param("parent_id") String parent_id);

	//查询素所有子结构也包括自己
	public List<Map<String,String>> getOrg(@Param("org_query_id") String org_query_id);

	//由用户登录名获取当前机构的queryID，查询所有子机构信息用
	public String getUserOrg(@Param("login_name") String doc_name);

	//查询当前queryID是否存在
	public int getOrgQueryIDcount(@Param("org_query_id") String id);

	//通过org_id获取到queryId
	public String getQueryIdByOrgId(@Param("org_id") String id);

	//通过登录名称获取到orgid
	public String getOrgIdByLoginName(@Param("userName") String userName);

	//通过销售ID获取到当前机构的queryID
	@SelectProvider (type=BuildSqlClass.class,method = "getQueryIdByDocId")
	public String getQueryIdByDocId(@Param("doc_id") String doc_id);

	@SelectProvider (type=BuildSqlClass.class,method = "getDocIdListByQueryId")
	public List<String> getDocIdListByQueryId(@Param("queryId") String queryId);

	public static class BuildSqlClass{

       public String getQueryIdByDocId(Map<String, Object> paramMap){

		   return new SQL() {{
			   SELECT("b.org_query_id");
			   FROM ( "hrip_org_doc a" );
			   INNER_JOIN ( "hrip_org b on a.ORG_ID = b.ORG_ID" );
               WHERE ( "a.doc_id = #{doc_id}" );
		   }}.toString();
	   }

	   public String getDocIdListByQueryId(Map<String, Object> paramMap){
       	    return new SQL (){{
       	    	SELECT ( "a.doc_id" );
       	    	FROM ("hrip_org_doc a");
                INNER_JOIN ( "hrip_org b on a.ORG_ID = b.ORG_ID" );
				WHERE ( "org_query_id like CONCAT(#{queryId,jdbcType=VARCHAR},'%')" );
                WHERE ( "org_query_id != #{queryId}" );
			}}
       	    .toString ();
	   }

	}

}
