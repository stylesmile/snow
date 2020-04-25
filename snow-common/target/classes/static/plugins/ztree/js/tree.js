//------------------------------------List Convert to Tree ----------------------------------------------------//
/**
 * 将list装换成tree  封装到JqueryUtils
 * @param {Object } id    节点主ID
 * @param {Object } pId   父节点ID
 * @param {Object } list  list数据
 * @return {Node} - 自定义Node树节点
 * @author Jason - jasonandy@hotmail.com
 */
function listToTree(id, pId, list) {

    convertToNodeList(list);

    /**
     * @param {} list        list
     * @param {} pId        父节点
     * @return {Boolean}    是否存在父节点
     * @description now.id = other.pid   other 的父节点为 noew
     */
    function exists(list, pId) {
        for (var i = 0; i < list.length; i++) {
            if (list[i][id] == pId) {
                return true;
            }
        }
        return false;
    }

    /**
     * 树节点数据  最终数据结构
     * @type  Node treeNode
     */
    var nodes = [];


    /**
     * 将所有的节点数据装入List
     * @type Number
     */
    for (var i = 0; i < list.length; i++) {
        var row = list[i];
        if (!exists(list, row[pId])) {//now.pid != new.id
            nodes.push(row);//new ids
        }
    }

    /**
     * 父节点
     * @type Node
     */
    var pNodes = [];

    /**
     * 将所有的子节点数据装入 pNodes
     * @type pNodes
     */
    for (var i = 0; i < nodes.length; i++) {
        pNodes.push(nodes[i]);
    }


    /**
     * 循环处理所有节点数据并进行封装
     */
    while (pNodes.length) {

        /**
         *  把数组的第一个元素从其中删除，并返回第一个元素的值
         *  the parent node
         */
        var node = pNodes.shift();

        /**
         *
         * get the children nodes
         */
        for (var i = 0; i < list.length; i++) {
            var row = list[i];
            /**
             * 取出list所有数据 比较处理
             *
             * 这里可以定制化 Node 节点数据结构
             * {  
             *   "isActive": true, 
             *   "isRoot": true, 
             *   "title": "标题1",
             *   "items": [
             *       {
             *           "text": "内容1"
             *       }, 
             *       {
             *           "text": "内容2"
             *       }
             *   ]
             * }
             */
            if (row[pId] == node[id]) {
                /**
                 * 如果有items 直接放入
                 */
                if (node.items) {
                    node.items.push(row);
                } else {
                    node.items = [row];
                }
                pNodes.push(row);
            }
        }
    }
    return nodes;
}

/**
 * Node 节点数据封装
 * @param {} list  转为map结构数据
 * @return {}      list 需要转换的list
 */
function convertToNodeList(list) {
    $.each(list, function (i, e) {
        e['title'] = e.NAME;
        e['isRoot'] = (e.PARENT_ID == '-1');
        e['isActive'] = (e.ENABLE_STATUS == '01');
    })
    return list;
}

    function simpleListToTree(oldArr){
      oldArr.forEach(element => {
        let parentId = element.parentId;
        if(parentId !== 0){
          oldArr.forEach(ele => {
            element.title = element.name;
            //delete element.name;

            if(ele.id == parentId){ //当内层循环的ID== 外层循环的parendId时，（说明有children），需要往该内层id里建个children并push对应的数组；
              if(!ele.children){
                ele.children = [];
              }
              ele.children.push(element);
            }
          });
        }
      });
      console.log(oldArr) //此时的数组是在原基础上补充了children;
      oldArr = oldArr.filter(ele => ele.parentId === 0); //这一步是过滤，按树展开，将多余的数组剔除；
      console.log(oldArr)
      return oldArr;
    }

//------------------------------------List Convert to Tree End----------------------------------------------------//