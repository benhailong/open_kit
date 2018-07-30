package cc.openkit.kitChat.rongcloud.service;

import cc.openkit.kitChat.rongcloud.model.RongcoludModel;
import cc.openkit.kitChat.rongcloud.rong.methods.Chatroom;
import cc.openkit.kitChat.rongcloud.rong.methods.Group;
import cc.openkit.kitChat.rongcloud.rong.methods.User;
import cc.openkit.kitChat.rongcloud.rong.models.*;

public class RongcloudService {

    public static void main(String[] args) throws Exception {

//        TokenResult token = getToken("123456", "贲海龙", "");
//
//        System.out.println("获取Token："+token);
//
//        Map map = AppUtil.toMap(token);



//        System.out.println("创建聊天室："+create("123789","测试创建聊天室"));
//



//        System.out.println("加入聊天室："+join(userId,"123789"));
//
//        System.out.println("查询聊天室记录："+query("123789"));
//        System.out.println("查询聊天室内用户方法："+queryUser("123789","10","1"));
    }

    /**
     * 获取 Token 方法
     *
     * @param  rongcoludModel:融云的对象。（必传）
     * @param  userId:用户 Id，最大长度 64 字节.是用户在 App 中的唯一标识码，必须保证在同一个 App 内不重复，重复的用户 Id 将被当作是同一用户。（必传）
     * @param  name:用户名称，最大长度 128 字节.用来在 Push 推送时显示用户的名称.用户名称，最大长度 128 字节.用来在 Push 推送时显示用户的名称。（必传）
     * @param  portraitUri:用户头像 URI，最大长度 1024 字节.用来在 Push 推送时显示用户的头像。（必传）
     *
     * @return TokenResult
     **/

    public static TokenResult getToken(RongcoludModel rongcoludModel,String userId, String name, String portraitUri)throws Exception{
        User user = new User(rongcoludModel.getAppkey(),rongcoludModel.getAppservice());
        // 获取公共token
        TokenResult token = user.getToken(userId, name, portraitUri);
        // json 解析到 map
        return token;
    }

    /**
     * 刷新用户信息方法
     *
     * @param  rongcoludModel:融云的对象。（必传）
     * @param  userId:用户 Id，最大长度 64 字节.是用户在 App 中的唯一标识码，必须保证在同一个 App 内不重复，重复的用户 Id 将被当作是同一用户。（必传）
     * @param  name:用户名称，最大长度 128 字节。用来在 Push 推送时，显示用户的名称，刷新用户名称后 5 分钟内生效。（可选，提供即刷新，不提供忽略）
     * @param  portraitUri:用户头像 URI，最大长度 1024 字节。用来在 Push 推送时显示。（可选，提供即刷新，不提供忽略）
     *
     * @return CodeSuccessResult
     **/
    public static CodeSuccessResult userRefresh(RongcoludModel rongcoludModel,String userId, String name, String portraitUri) throws Exception {
        User user = new User(rongcoludModel.getAppkey(),rongcoludModel.getAppservice());
        return user.refresh(userId, name, portraitUri);
    }

    /**
     * 检查用户在线状态 方法
     *
     * @param  rongcoludModel:融云的对象。（必传）
     * @param  userId:用户 Id，最大长度 64 字节。是用户在 App 中的唯一标识码，必须保证在同一个 App 内不重复，重复的用户 Id 将被当作是同一用户。（必传）
     *
     * @return CheckOnlineResult
     **/
    public static CheckOnlineResult userCheckOnline(RongcoludModel rongcoludModel,String userId) throws Exception {
        User user = new User(rongcoludModel.getAppkey(),rongcoludModel.getAppservice());
        return user.checkOnline(userId);
    }


    /**
     * 创建聊天室
     *
     * @param  rongcoludModel:融云的对象。（必传）
     * @param  id:要创建的聊天室的id。（必传）
     * @param  name:要创建的聊天室的name。（必传）
     *
     * @return codeSuccessResult
     */
    public static CodeSuccessResult create(RongcoludModel rongcoludModel,String id,String name) throws Exception {
        Chatroom chatroom = new Chatroom(rongcoludModel.getAppkey(),rongcoludModel.getAppservice());
        ChatRoomInfo c[] = new ChatRoomInfo[1];
        c[0] = new ChatRoomInfo(id,name); // 聊天室对象
        CodeSuccessResult codeSuccessResult = chatroom.create(c);
        return codeSuccessResult;
    }

    /**
     * 加入聊天室方法
     *
     * @param  rongcoludModel:融云的对象。（必传）
     * @param  userId:要加入聊天室的用户 Id，可提交多个，最多不超过 50 个。（必传）
     * @param  chatroomId:要加入的聊天室 Id。（必传）
     *
     * @return CodeSuccessResult
     **/
    public static CodeSuccessResult join(RongcoludModel rongcoludModel,String[] userId, String chatroomId) throws Exception {
        Chatroom chatroom = new Chatroom(rongcoludModel.getAppkey(),rongcoludModel.getAppservice());
        return chatroom.join(userId,chatroomId);
    }

    /**
     * 查询聊天室详细信息方法
     *
     * @param  rongcoludModel:融云的对象。（必传）
     * @param  id:要查询的聊天室id（必传）
     *
     * @return ChatroomQueryResult
     **/
    public static ChatroomQueryResult query(RongcoludModel rongcoludModel, String id) throws Exception {
        Chatroom chatroom = new Chatroom(rongcoludModel.getAppkey(),rongcoludModel.getAppservice());
        String chatroomId[] = {id};
        return chatroom.query(chatroomId);
    }

    /**
     * 查询聊天室内用户方法
     *
     * @param  rongcoludModel:融云的对象。（必传）
     * @param  chatroomId:要查询的聊天室 ID。（必传）
     * @param  count:要获取的聊天室成员数，上限为 500 ，超过 500 时最多返回 500 个成员。（必传）
     * @param  order:加入聊天室的先后顺序， 1 为加入时间正序， 2 为加入时间倒序。（必传）
     *
     * @return ChatroomUserQueryResult
     **/
    public static ChatroomUserQueryResult queryUser(RongcoludModel rongcoludModel,String chatroomId, String count, String order) throws Exception {
        Chatroom chatroom = new Chatroom(rongcoludModel.getAppkey(),rongcoludModel.getAppservice());
        return chatroom.queryUser(chatroomId,count,order);
    }

    /**
     * 销毁聊天室方法
     *
     * @param  rongcoludModel:融云的对象。（必传）
     * @param  id:要销毁的聊天室 Id。（必传）
     *
     * @return CodeSuccessResult
     **/
    public static CodeSuccessResult destroy(RongcoludModel rongcoludModel,String id) throws Exception {
        Chatroom chatroom = new Chatroom(rongcoludModel.getAppkey(),rongcoludModel.getAppservice());
        String chatroomId[] = {id};
        return chatroom.destroy(chatroomId);
    }

    /**
     * 创建群组方法（创建群组，并将用户加入该群组，用户将可以收到该群的消息，同一用户最多可加入 500 个群，每个群最大至 3000 人，App 内的群组数量没有限制.注：其实本方法是加入群组方法 /group/join 的别名。）
     *
     * @param  rongcoludModel:融云的对象。（必传）
     * @param  userId:要加入群的用户 Id。（必传）
     * @param  groupId:创建群组 Id。（必传）
     * @param  groupName:群组 Id 对应的名称。（必传）
     *
     * @return CodeSuccessResult
     **/
    public static CodeSuccessResult groupCreate(RongcoludModel rongcoludModel,String[] userId, String groupId, String groupName) throws Exception {
        Group group = new Group(rongcoludModel.getAppkey(),rongcoludModel.getAppservice());
        return group.create(userId,groupId,groupName);
    }

    /**
     * 同步用户所属群组方法（当第一次连接融云服务器时，需要向融云服务器提交 userId 对应的用户当前所加入的所有群组，此接口主要为防止应用中用户群信息同融云已知的用户所属群信息不同步。）
     *
     * @param  rongcoludModel:融云的对象。（必传）
     * @param  userId:被同步群信息的用户 Id。（必传）
     * @param  groupInfo:该用户的群信息，如群 Id 已经存在，则不会刷新对应群组名称，如果想刷新群组名称请调用刷新群组信息方法。
     *
     * @return CodeSuccessResult
     **/
    public static CodeSuccessResult groupSync(RongcoludModel rongcoludModel,String userId, GroupInfo[] groupInfo) throws Exception {
        Group group = new Group(rongcoludModel.getAppkey(),rongcoludModel.getAppservice());
        return group.sync(userId,groupInfo);
    }

    /**
     * 刷新群组信息方法
     *
     * @param  rongcoludModel:融云的对象。（必传）
     * @param  groupId:群组 Id。（必传）
     * @param  groupName:群名称。（必传）
     *
     * @return CodeSuccessResult
     **/
    public static CodeSuccessResult groupRefresh(RongcoludModel rongcoludModel,String groupId, String groupName) throws Exception {
        Group group = new Group(rongcoludModel.getAppkey(),rongcoludModel.getAppservice());
        return group.refresh(groupId,groupName);
    }

    /**
     * 将用户加入指定群组，用户将可以收到该群的消息，同一用户最多可加入 500 个群，每个群最大至 3000 人。
     *
     * @param  rongcoludModel:融云的对象。（必传）
     * @param  userId:要加入群的用户 Id，可提交多个，最多不超过 1000 个。（必传）
     * @param  groupId:要加入的群 Id。（必传）
     * @param  groupName:要加入的群 Id 对应的名称。（必传）
     *
     * @return CodeSuccessResult
     **/
    public static CodeSuccessResult groupJoin(RongcoludModel rongcoludModel,String[] userId, String groupId, String groupName) throws Exception {
        Group group = new Group(rongcoludModel.getAppkey(),rongcoludModel.getAppservice());
        return group.join(userId,groupId,groupName);
    }

    /**
     * 查询群成员方法
     *
     * @param  rongcoludModel:融云的对象。（必传）
     * @param  groupId:群组Id。（必传）
     *
     * @return GroupUserQueryResult
     **/
    public static GroupUserQueryResult groupQueryUser(RongcoludModel rongcoludModel,String groupId) throws Exception {
        Group group = new Group(rongcoludModel.getAppkey(),rongcoludModel.getAppservice());
        return group.queryUser(groupId);
    }

    /**
     * 退出群组方法（将用户从群中移除，不再接收该群组的消息.）
     *
     * @param  rongcoludModel:融云的对象。（必传）
     * @param  userId:要退出群的用户 Id.（必传）
     * @param  groupId:要退出的群 Id.（必传）
     *
     * @return CodeSuccessResult
     **/
    public static CodeSuccessResult groupQuit(RongcoludModel rongcoludModel,String[] userId, String groupId) throws Exception {
        Group group = new Group(rongcoludModel.getAppkey(),rongcoludModel.getAppservice());
        return group.quit(userId,groupId);
    }

    /**
     * 解散群组方法。（将该群解散，所有用户都无法再接收该群的消息。）
     *
     * @param  rongcoludModel:融云的对象。（必传）
     * @param  userId:操作解散群的用户 Id。（必传）
     * @param  groupId:要解散的群 Id。（必传）
     *
     * @return CodeSuccessResult
     **/
    public static CodeSuccessResult groupDismiss(RongcoludModel rongcoludModel,String userId, String groupId) throws Exception {
        Group group = new Group(rongcoludModel.getAppkey(),rongcoludModel.getAppservice());
        return group.dismiss(userId,groupId);
    }

}
