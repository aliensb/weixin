/**
 * Created by thoshba on 10/17/2016.
 */
function get(selector){
    if(selector==null) return null;
    var tag=selector.charAt(0);
    var result=null;
    switch(tag){
        case "#":
            result=document.getElementById(selector.substr(1));
            break;
        case ".":
            result=document.getElementsByClassName(selector.substr(1));
            break;
        default:
            result=document.getElementsByTagName(selector);
            break;
    }
    return result;
}

function AddLoadEvent(func){
    var old=window.onload;
    if(old==null){
        window.onload=func;
    }else{
        window.onload=function(){
            old();
            func();
        };
    }
}

function bindEvent(elem,event,handle){
    elem.addEventListener(event,handle);
}

function getLastElement(parent){
    var result=null;
    var children=parent.childNodes;
    for(var i=children.length-1;i>=0;i--){
        if(children[i].nodeType==1){
            result=children[i];
            break;
        }
    }
    return result;
}
function getElementByIndex(parent,index){
    var result = null;
    var children = parent.childNodes;
    var count = 0;
    for(var i = 0;i < children.length; i++){
        if(children[i].nodeType==1){
            if(count==index){
                result=children[i];
                break;
            }
            count++;
        }
    }
}
function insertAfter(elem,target){
    var parent = target.parentNode;
    if(parent.lastChild==target){
        parent.appendChild(elem);
    }else{
        var next=target.nextSibling;
        parent.insertBefore(elem,next);
    }
}