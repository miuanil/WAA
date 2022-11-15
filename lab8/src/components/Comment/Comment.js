import './Comment.css'

const Comments = (props) => {

    return (
        <li className='Comments'>{props.comment.name}</li>
    );
}

export default Comments;