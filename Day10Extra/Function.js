function functionName(parameter1,parameter2){
    return parameter1*parameter2
}

alert(functionName(2,3))


function functionWithoutReturn(parameter1,parameter2){
    alert("This is a functino without 'return' statement")
}

functionWithoutReturn()


function functionName(x,y){
    if(y == undefined){
        y=2
    }
    
}

x = findMax(1,123,500,115,44,88)
alert(x)

//Arguments Object
function findMax(){
    // var i,max=0
    // for(i=0;i<arguments.length;i++){
    //     if(arguments[i]>max)
    //     max = arguments[i]
    // }

    return arguments[0]

    //return max
}