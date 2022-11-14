import './PostDetails.css';


const PostDetails = (props) => {

    let postDetailsDisplay = null;

    if (props.id !== 0) {

        postDetailsDisplay = (

            <div className="PostDetails">
                <h1>Post Details</h1>
                <h3>{props.post.title}</h3>
                <div>
                    <i>{props.post.author}</i>
                    <br />
                    <div className='content' style={{ textAlign: "left" }}>
                        {props.post.content}
                    </div>
                </div>
                <button>edit</button>
                <button>delete</button>
            </div>
        );
    }

    return postDetailsDisplay;



}

export default PostDetails;