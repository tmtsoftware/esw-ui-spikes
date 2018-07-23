import React, {Component} from 'react';
import mysequencer from "mysequencer";

class Comment extends Component {
    render() {
        const {
            author,
            comment
        } = this.props;
        const A = mysequencer.HeaderComponent.MyHeader;
        return (
            <div className="comment">
                <p>Comment Author - {author}</p>
                <p>Comment - {comment}</p>
                {A}
                { console.log(mysequencer.AA.dd())}
            </div>
        );
    }
}

export default Comment;