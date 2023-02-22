import React from 'react';

function Todolist() {
    
    //const [description, setDescription] = React.useState('');
    //const [date, setDate] = React.useState('');
    const [todo, setTodo] = React.useState({description: '', date: ''})
    const [todos, setTodos] = React.useState([]);

    const handelAddToDo = () => {
        if(todo.date==='' || todo.description===''){
            alert("Value missing")
        } else {
            setTodos([todo, ...todos]);
            setTodo({description: '', date: ''});
        }
    }

    const deleteToDo = (row) => {
        console.log("delete to do " + row)
        setTodos(todos.filter((todo, index) => index !== row))
    }

    return (
        <div>
            <h1>My To-Do List</h1>
            <input 
                placeholder='Description' 
                value={todo.description}
                onChange={(event) => setTodo({...todo, description:event.target.value})}
            />
            <input 
                type='date'
                value={todo.date}
                onChange={(event) => setTodo({...todo, date:event.target.value})}
            />
            <button onClick={handelAddToDo}>Add To-Do</button>

            <table>
                <tbody>
                    <tr>
                        <th>Date</th>
                        <th>Description</th>
                    </tr>
                    {
                        todos.map((todo, index) => (
                            <tr key={index}>
                                <td>{todo.date}</td>
                                <td>{todo.description}</td>
                                <td><button onClick={() => deleteToDo(index)}>Delete</button></td>
                            </tr>
                        )
                        )
                    }
                </tbody>
            </table>
        </div>
    );
}


export default Todolist;
