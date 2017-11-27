package cn.uc.yiqibang.utils;

/**
 * �ַ����Ĳ���ƴ����
 * @author Administrator
 *
 */
public class Constants {
	
	//��Ӧ��
	public static final int RETCODE_SUCCESS=0;
	public static final int RETCODE_FAIL=2000;

	//����ӳ���ļ�.xml�İ��ĸ�·��
	public static final String root="cn.uc.yiqibang.mapper";
	
	//����mapperӳ���ļ�������
	public static final String commentMapper=".TCommentMapper";
	public static final String newsMapper=".TNewsMapper";
	public static final String typeMapper=".TTypeMapper";
	public static final String adminMapper=".TAdminMapper";
	public static final String userMapper=".TUserMapper";
	
	
	//���������sql����id����
	public static final String selectAll=".selectAll";
	public static final String selectByPrimaryKey=".selectByPrimaryKey";
	public static final String selectByLike=".selectByLike";
	public static final String insert=".insert";
	public static final String insertSelective=".insertSelective";
	public static final String updateByPrimaryKeySelective=".updateByPrimaryKeySelective";
	public static final String deleteByPrimaryKey=".deleteByPrimaryKey";
	public static final String deleteByCondition=".deleteByCondition";
	public static final String selectByTypeId=".selectByTypeId";
	public static final String selectAllByPage=".selectAllByPage";
	public static final String updateByCondition=".updateByCondition";
	public static final String selectByCondition=".selectByCondition";
	public static final String selectByNameAndPwd=".selectByNameAndPwd";
	public static final String selectByUserId=".selectByUserId";
	public static final String getAllCountByNewid=".selectAllCountByNewid";
	public static final String selectLastByNewid=".selectLastByNewid";
	public static final String selectByUsername=".selectByUsername";
	public static final String updateNewsViewCount=".updateNewsViewCount";
	
	
	
	
	
	
	//Comment���۵Ĳ������·��
	public static final int PageCounts=5;
	public static final String commentMapper_selectAll=root+commentMapper+selectAll;
	public static final String commentMapper_insert=root+commentMapper+insert;
	public static final String commentMapper_deleteByCondition=root+commentMapper+deleteByCondition;	
	public static final String commentMapper_selectAllByPage=root+commentMapper+selectAllByPage;
	public static final String commentMapper_insertSelective=root+commentMapper+insertSelective;
	public static final String commentMapper_deleteByPrimaryKey=root+commentMapper+deleteByPrimaryKey;
	public static final String commentMapper_selectByLike=root+commentMapper+selectByLike;
	public static final String commentMapper_updateByPrimaryKeySelective=root+commentMapper+updateByPrimaryKeySelective;
	public static final String commentMapper_selectByPrimaryKey=root+commentMapper+selectByPrimaryKey;
	public static final String commentMapper_getAllCountByNewid=root+commentMapper+getAllCountByNewid;
	public static final String commentMapper_selectLastByNewid=root+commentMapper+selectLastByNewid;

	
	
	//News���ŵĲ������·��
	public static final int newsPageCounts=5;
	public static final String newsMapper_selectAll=root+newsMapper+selectAll;
	public static final String newsMapper_insert=root+newsMapper+insert;
	public static final String newsMapper_insertSelective=root+newsMapper+insertSelective;
	public static final String newsMapper_updateByPrimaryKeySelective=root+newsMapper+updateByPrimaryKeySelective;
	public static final String newsMapper_updateByCondition=root+newsMapper+updateByCondition;
	public static final String newsMapper_selectByLike=root+newsMapper+selectByLike;
	public static final String newsMapper_deleteByPrimaryKey=root+newsMapper+deleteByPrimaryKey;
	public static final String newsMapper_selectByTypeId=root+newsMapper+selectByTypeId;
	public static final String newsMapper_deleteByCondition=root+newsMapper+deleteByCondition;
	public static final String newsMapper_selectAllByPage=root+newsMapper+selectAllByPage;
	public static final String newsMapper_selectByPrimaryKey=root+newsMapper+selectByPrimaryKey;
	public static final String newsMapper_updateNewsViewCount=root+newsMapper+updateNewsViewCount;

	
	//Type���ŷ���Ĳ���·��
	public static final int typePageCounts=5;
	public static final String typeMapper_selectAllByPage=root+typeMapper+selectAllByPage;
	public static final String typeMapper_insertSelective=root+typeMapper+insertSelective;
	public static final String typeMapper_deleteByPrimaryKey=root+typeMapper+deleteByPrimaryKey;
	public static final String typeMapper_selectByLike=root+typeMapper+selectByLike;
	public static final String typeMapper_updateByPrimaryKeySelective=root+typeMapper+updateByPrimaryKeySelective;
	public static final String typeMapper_selectAll=root+typeMapper+selectAll;
	public static final String typeMapper_selectByPrimaryKey=root+typeMapper+selectByPrimaryKey;
	public static final String typeMapper_deleteByCondition=root+typeMapper+deleteByCondition;
	public static final String typeMapper_selectByCondition=root+typeMapper+selectByCondition;
	
	
	//User�û��Ĳ���·��
	public static final int userPageCounts=5;
	public static final String userMapper_selectAllByPage=root+userMapper+selectAllByPage;
	public static final String userMapper_insertSelective=root+userMapper+insertSelective;
	public static final String userMapper_deleteByPrimaryKey=root+userMapper+deleteByPrimaryKey;
	public static final String userMapper_selectByLike=root+userMapper+selectByLike;
	public static final String userMapper_updateByPrimaryKeySelective=root+userMapper+updateByPrimaryKeySelective;
	public static final String userMapper_selectAll=root+userMapper+selectAll;
	public static final String userMapper_selectByPrimaryKey=root+userMapper+selectByPrimaryKey;
	public static final String userMapper_deleteByCondition=root+userMapper+deleteByCondition;
	public static final String userMapper_selectByNameAndPwd=root+userMapper+selectByNameAndPwd;
	public static final String userMapper_selectByUsername=root+userMapper+selectByUsername;
	
	
	//Admin����Ա�Ĳ������·��
		public static final int adminPageCounts=5;
		public static final String adminMapper_selectAll=root+adminMapper+selectAll;
		public static final String adminMapper_insert=root+adminMapper+insert;
		public static final String adminMapper_insertSelective=root+adminMapper+insertSelective;
		public static final String adminMapper_updateByPrimaryKeySelective=root+adminMapper+updateByPrimaryKeySelective;
		public static final String adminMapper_selectByCondition=root+adminMapper+selectByCondition;
		public static final String adminMapper_selectByLike=root+adminMapper+selectByLike;
		public static final String adminMapper_deleteByPrimaryKey=root+adminMapper+deleteByPrimaryKey;
		public static final String adminMapper_selectByTypeId=root+adminMapper+selectByTypeId;
		public static final String adminMapper_deleteByCondition=root+adminMapper+deleteByCondition;
		public static final String adminMapper_selectAllByPage=root+adminMapper+selectAllByPage;
		public static final String adminMapper_selectByPrimaryKey=root+adminMapper+selectByPrimaryKey;
		public static final String adminMapper_selectByUserId=root+adminMapper+selectByUserId;
	
}
