import './Post.css';

const Post = (props) => {

    return (
        <div className='Content' onClick={props.setSelected}>
            <h1>{props.title}</h1>
            <p><i>{props.author}</i></p>
        </div>
    )

};

export default Post;