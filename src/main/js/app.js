const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class TodoItem extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.todoItem.name}</td>
			</tr>
		)
	}
}

class TodoItemList extends React.Component{
	render() {
		const todoItems = this.props.todoItems.map(todoItem =>
			<TodoItem key={todoItem._links.self.href} todoItem={todoItem}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>Name</th>
					</tr>
					{todoItems}
				</tbody>
			</table>
		)
	}
}

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {todoItems: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api/todoItems'}).done(response => {
			this.setState({todoItems: response.entity._embedded.todoItems});
		});
	}

	render() {
		return (
			<TodoItemList todoItems={this.state.todoItems}/>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)