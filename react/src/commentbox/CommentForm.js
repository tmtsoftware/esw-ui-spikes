import React, {Component} from 'react';
import styled, {css} from 'styled-components';

const Button = styled.button`
        border-radius: 3px;
        padding: 0.25em 1em;
        margin: 0 1em;
        background: transparent;
        color: darkblue;
        border: 2px solid darkblue;
        
        ${props => props.primary && css`
        background: lightblue;
        color: darkblue;`}
      `;

const Text = styled.input`
        padding: 0.5em;
        margin: 0.5em;
        color: palevioletred;
        background: papayawhip;
        border: none;
        border-radius: 3px;
        `;

class CommentForm extends Component {

    constructor() {
        super();

        this._handleSubmit = this._handleSubmit.bind(this);
        this._updateAuthor = this._updateAuthor.bind(this);
        this._updateComment = this._updateComment.bind(this);

        this.state = {
            author: "",
            comment: ""
        }

    }

    render() {
        return (
            <form className={`comment-form ${this.props.className}`} onSubmit={this._handleSubmit}>
                <Text type="text" placeholder="author" value={this.state.author} onChange={this._updateAuthor}/>
                <Text type="text" placeholder="comment" value={this.state.comment} onChange={this._updateComment}/>
                <Button className = 'my-button' primary type="submit">Post Comment</Button>
            </form>
        );
    }

    _handleSubmit(event) {
        event.preventDefault();
        this.props.add(this.state.author, this.state.comment);
        this.setState({author: "", comment: ""});
    }

    _updateAuthor(event) {
        this.setState({
            author: event.target.value
        })
    }

    _updateComment(event) {
        this.setState({
            comment: event.target.value
        })
    }
}

export {CommentForm, Button};