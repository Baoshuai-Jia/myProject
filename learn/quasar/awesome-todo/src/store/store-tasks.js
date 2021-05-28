const state ={
  tasks:[
    {
      id:1,
      name:'Go to shop',
      completed:false,
      dueDate:'2021/05/27',
      dueTime:'16:00'
    },
    {
      id:2,
      name:'Get bananas',
      completed:false,
      dueDate:'2021/05/28',
      dueTime:'16:01'
    },
    {
      id:3,
      name:'Get apples',
      completed:false,
      dueDate:'2021/05/29',
      dueTime:'16:02'
    }
  ]
}

const mutation ={

}

const actions = {

}

const getters = {
  tasks:(state) => {
    return state.tasks
  }
}

export default{
  namespaced: true,
  state,
  mutation,
  actions,
  getters
}
