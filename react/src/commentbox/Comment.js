import React, {Component} from 'react';
import mysequencer from "mysequencer";

class Comment extends Component {
    render() {
        const {
            author,
            comment
        } = this.props;
        const A = mysequencer.Interoperability.Header;
        return (
            <div className="comment">
                <p>Comment Author - {author}</p>
                <p>Comment - {comment}</p>
                {A}
            </div>
        );
    }
}

export default Comment;