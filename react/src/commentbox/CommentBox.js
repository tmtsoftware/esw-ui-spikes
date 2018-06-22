import React, {Component} from 'react';
import Comment from './Comment';
import {CommentForm, Button} from './CommentForm';
import styled, {css} from "styled-components";

const customButtonCss = css`
    border: 2px solid red;
    ${props => props.primary && css`
        background: tomato;
        color: white;`
    }
    `;

const MyButton = Button.extend`
    ${customButtonCss}
`;

const Title = styled.h3`
  font-size: 1.5em;
  text-align: center;
  color: palevioletred;
`;

const Wrapper = styled.section`
  padding: 4em;
  background: papayawhip;
`;


const MyCommentForm = styled(CommentForm)`
    button{
        ${customButtonCss}
    }
`;

class CommentBox extends Component {

    constructor() {
        super();

        this.state = {
            showComments: false,
            comments: []
        };

        this._getComments = this._getComments.bind(this);
        this._handleClick = this._handleClick.bind(this);
        this._addComment = this._addComment.bind(this)
    }

    _getComments = () => {
        return this.state.comments.map((comment, index) => {
            return <Comment author={comment.author} comment={comment.comment} key={index}/>
        })
    };

    _addComment = (author, comment) => {
        this.setState({
            comments: this.state.comments.concat([{author, comment}])
        });
        this.props.updateNoOfComments(this.state.comments.length + 1)
    };

    _handleClick = () => {
        this.setState({
            showComments: !this.state.showComments
        })
    };

    render() {
        let commentNodes;
        let buttonText = "Show Comments";
        const comments = this._getComments();
        if (this.state.showComments) {
            buttonText = "Hide Comments";
            commentNodes = <div className="comment-list">{comments}</div>
        }

        return (
            <div className="comment-box">
                <Wrapper>
                    <Title>Comments</Title>
                    <MyButton primary onClick={this._handleClick}> {buttonText} </MyButton>
                </Wrapper>
                {commentNodes}
                <CommentForm add={this._addComment} />
                <MyCommentForm primary add={this._addComment}/>

            </div>
        );
    }
}

export default CommentBox;