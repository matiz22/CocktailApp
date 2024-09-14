public enum DataState<T> {
	case loading
	case success(data: T)
	case error(error: String)
}
